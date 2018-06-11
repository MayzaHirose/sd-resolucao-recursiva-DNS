
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mayza
 */
public class ServidorNomeDINImpl extends java.rmi.server.UnicastRemoteObject implements IServidorNomeDIN {

    private CaminhoAbsoluto caminhoAbsoluto;
    private String enderecoServidorDIN = "186.233.152.34";

    public ServidorNomeDINImpl()
            throws java.rmi.RemoteException {
        super();
    }

    @Override
    public String resolveNome(CaminhoAbsoluto caminhoAbsoluto) throws RemoteException {
        System.out.println("ServidorNomeDIN");
        String proximoRotulo;
        this.caminhoAbsoluto = caminhoAbsoluto;

        proximoRotulo = this.caminhoAbsoluto.getProximoRotulo();

        if (proximoRotulo.equals("") || proximoRotulo.equals("www")) {
            System.out.println("ServidorNomeDIN - Endereco");
            return enderecoServidorDIN;
        } else {
            return "not found";
        }
    }

}
