
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
public class ServidorConteudosRaizImpl extends java.rmi.server.UnicastRemoteObject implements IServidorConteudosRaiz {

    private IServidorConteudosDIN servidorConteudosDIN;

    public ServidorConteudosRaizImpl()
            throws java.rmi.RemoteException {
        super();
    }

    @Override
    public String carregaConteudoEndereco(String retornoServidorEndereco) throws RemoteException {
        switch (retornoServidorEndereco) {
            case "186.233.152.34":
                try {
                    servidorConteudosDIN = (IServidorConteudosDIN) Naming.lookup("//127.0.0.1:1099/ServidorConteudosDINService");
                    return servidorConteudosDIN.carregaConteudoDIN();
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(ServidorConteudosRaizImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "1.1.1.1":
                return "Outro site";
             
            default: 
                return "Conteudo nao disponivel";
        }
    }
}
