
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mayza
 */
public class ServidorNomesRaizImpl extends java.rmi.server.UnicastRemoteObject implements IServidorNomesRaiz {

    private final Map<String, String> tabelaServidores = new HashMap<>();
    private CaminhoAbsoluto caminhoAbsoluto;
    private IServidorNomeBR servidorNomeBR;

    public ServidorNomesRaizImpl()
            throws java.rmi.RemoteException {
        super();
        tabelaServidores.put("br", "ServidorBR");
        tabelaServidores.put("com", "ServidorCOM");
        tabelaServidores.put("jp", "ServidorJP");
    }

    @Override
    public String procuraEndereco(boolean isRecursivo, String url) throws RemoteException {
        caminhoAbsoluto = new CaminhoAbsoluto();
        String proximoRotulo;

        transformaUrlRotulos(url);
        proximoRotulo = caminhoAbsoluto.getProximoRotulo();
        
        String temp = tabelaServidores.get(proximoRotulo);
        if (temp != null) {
            switch (temp) {
                case "ServidorBR": {
                    System.out.println("ServidorNomesRaiz - BR");
                    try {
                        servidorNomeBR = (IServidorNomeBR) Naming.lookup("//127.0.0.1:1099/ServidorNomeBRService");
                        return servidorNomeBR.resolveNome(caminhoAbsoluto);
                    } catch (NotBoundException | MalformedURLException ex) {
                        Logger.getLogger(ServidorNomesRaizImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case "ServidorCOM":
                    return "Nome Resolvido";

                case "ServidorJP":
                    return "Nome Resolvido";

                default:
                    return "not found";
            }
        } else {
            return "not found";
        }
    }

    private void transformaUrlRotulos(String url) {
        String[] rotulos = url.split("\\.");
        for (String rotulo : rotulos) {
            this.caminhoAbsoluto.adicionaRotuloCaminho(rotulo);
        }
    }

}
