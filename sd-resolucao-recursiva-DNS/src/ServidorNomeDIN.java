
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
public class ServidorNomeDIN {
    
    public ServidorNomeDIN() {
        try {
            IServidorNomeDIN servidorNomeDIN = new ServidorNomeDINImpl();
            Naming.rebind("//127.0.0.1:1099/ServidorNomeDINService", servidorNomeDIN);  
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    public static void main(String args[]) {
        new ServidorNomeDIN();
    }
}
