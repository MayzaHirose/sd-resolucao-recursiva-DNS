
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
public class ServidorNomeBRImpl extends java.rmi.server.UnicastRemoteObject implements IServidorNomeBR {

    private Map<String, String> tabelaServidores = new HashMap<>();
    private CaminhoAbsoluto caminhoAbsoluto;
    private IServidorNomeUEM servidorNomeUEM;

    public ServidorNomeBRImpl()
            throws java.rmi.RemoteException {
        super();
        tabelaServidores.put("uem", "ServidorUEM");
        tabelaServidores.put("uel", "ServidorUEL");
        tabelaServidores.put("ufpr", "ServidorUFPR");
    }

    @Override
    public String resolveNome(CaminhoAbsoluto caminhoAbsoluto) throws RemoteException {
        String proximoRotulo;
        this.caminhoAbsoluto = caminhoAbsoluto;

        proximoRotulo = this.caminhoAbsoluto.getProximoRotulo();

        String temp = tabelaServidores.get(proximoRotulo);
        if (temp != null) {
            switch (temp) {
                case "ServidorUEM": {
                    System.out.println("ServidorNomeBR - UEM");
                    try {
                        servidorNomeUEM = (IServidorNomeUEM) Naming.lookup("//127.0.0.1:1099/ServidorNomeUEMService");
                        return servidorNomeUEM.resolveNome(caminhoAbsoluto);
                    } catch (NotBoundException | MalformedURLException ex) {
                        Logger.getLogger(ServidorNomeBRImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case "ServidorUEL":
                    return "Nome Resolvido";

                case "ServidorUFPR":
                    return "Nome Resolvido";

                default:
                    return "not found";
            }
        } else {
            return "not found";
        }
    }

}
