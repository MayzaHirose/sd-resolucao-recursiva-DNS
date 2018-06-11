
import java.rmi.Naming;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mayza
 */
//CLIENTE/SERVIDOR
public class ServidorConteudosRaiz {
    
    public ServidorConteudosRaiz() {
        try {
            IServidorConteudosRaiz servidorConteudosRaiz = new ServidorConteudosRaizImpl();
            Naming.rebind("//127.0.0.1:1099/ServidorConteudosRaizService", servidorConteudosRaiz);            
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    public static void main(String args[]) {
        new ServidorConteudosRaiz();
    }
    
}
