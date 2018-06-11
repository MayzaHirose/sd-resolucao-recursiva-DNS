
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
//CLIENTE
public class Cliente {

    
    public static void main(String[] args) {

        boolean conectado = true;
        boolean isRecursivo = true;
        String url;
        String retornoServidorNomes;
        String retornoServidorConteudo;

        try {
            IServidorNomesRaiz servidorNomesRaiz = (IServidorNomesRaiz) Naming.lookup("//127.0.0.1:1099/ServidorNomesRaizService");
            IServidorConteudosRaiz servidorConteudosRaiz = (IServidorConteudosRaiz) Naming.lookup("//127.0.0.1:1099/ServidorConteudosRaizService");
            while (conectado) {
                System.out.print("\n\nPESQUISAR URL: ");
                Scanner entrada = new Scanner(System.in);
                url = entrada.nextLine();

                retornoServidorNomes = servidorNomesRaiz.procuraEndereco(isRecursivo, url);

                if (retornoServidorNomes.equals("not found")) {
                    System.out.println("Endereco da URL nao encontrada");
                } else {
                    retornoServidorConteudo = servidorConteudosRaiz.carregaConteudoEndereco(retornoServidorNomes);
                    System.out.println("Endereco: " + retornoServidorNomes + retornoServidorConteudo);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
