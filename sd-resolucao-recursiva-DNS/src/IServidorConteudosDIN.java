/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayza
 */
public interface IServidorConteudosDIN extends java.rmi.Remote {
    
    public String carregaConteudoDIN()
            throws java.rmi.RemoteException;
    
}
