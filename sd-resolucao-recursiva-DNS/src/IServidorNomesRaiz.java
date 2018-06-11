/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayza
 */
public interface IServidorNomesRaiz extends java.rmi.Remote {
    
    public String procuraEndereco(boolean isRecursivo, String url)
            throws java.rmi.RemoteException;
    
}
