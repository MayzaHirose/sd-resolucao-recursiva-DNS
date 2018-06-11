
import java.rmi.Naming;
import java.util.Scanner;

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
public class ServidorConteudosDIN {
    
    public ServidorConteudosDIN() {
        try {
            IServidorConteudosDIN servidorConteudosDIN = new ServidorConteudosDINImpl();
            Naming.rebind("//127.0.0.1:1099/ServidorConteudosDINService", servidorConteudosDIN);  
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    public static void main(String args[]) {
        new ServidorConteudosDIN();
    }
}
