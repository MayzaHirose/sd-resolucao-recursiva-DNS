
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
public class ServidorNomeUEMImpl extends java.rmi.server.UnicastRemoteObject implements IServidorNomeUEM {

    private Map<String, String> tabelaServidores = new HashMap<>();
    private CaminhoAbsoluto caminhoAbsoluto;
    private IServidorNomeDIN servidorNomeDIN;

    public ServidorNomeUEMImpl()
            throws java.rmi.RemoteException {
        super();
        tabelaServidores.put("din", "ServidorDIN");
        tabelaServidores.put("dma", "ServidorDMA");
        tabelaServidores.put("dep", "ServidorDEP");
    }

    @Override
    public String resolveNome(CaminhoAbsoluto caminhoAbsoluto) throws RemoteException {
        String proximoRotulo;
        this.caminhoAbsoluto = caminhoAbsoluto;

        proximoRotulo = this.caminhoAbsoluto.getProximoRotulo();

        String temp = tabelaServidores.get(proximoRotulo);
        if (temp != null) {
            switch (temp) {
                case "ServidorDIN": {
                    System.out.println("ServidorNomeUEM - DIN");
                    try {
                        servidorNomeDIN = (IServidorNomeDIN) Naming.lookup("//127.0.0.1:1099/ServidorNomeDINService");
                        return servidorNomeDIN.resolveNome(caminhoAbsoluto);
                    } catch (NotBoundException | MalformedURLException ex) {
                        Logger.getLogger(ServidorNomeUEMImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case "ServidorDMA":
                    return "Nome Resolvido";

                case "ServidorDEP":
                    return "Nome Resolvido";

                default:
                    return "not found";
            }
        } else {
            return "not found";
        }
    }

}
