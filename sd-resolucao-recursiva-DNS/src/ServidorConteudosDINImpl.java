
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
public class ServidorConteudosDINImpl extends java.rmi.server.UnicastRemoteObject implements IServidorConteudosDIN {
    
    public ServidorConteudosDINImpl()
            throws java.rmi.RemoteException {
            super();
    }

    @Override
    public String carregaConteudoDIN() throws RemoteException {
        return "\n\nSeja bem vindo(a) ao departamento de informatica\n\n"
                + "Atualmente o DIN e responsavel por dois cursos de graduacao\n"
                + "na area de Tecnologia de Informacao, um curso de Mestrado em\n"
                + "Ciencia da Computacao e um curso de Especializacao em Desenvolvimento\n"
                + "de Sistemas para Web, contando com um corpo docente constituido por\n"
                + "doutores e mestres formados nas melhores instituicoes do pais e do exterior.";
    }
 
}
