
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mayza
 */
public class CaminhoAbsoluto implements Serializable {

    private List<String> rotulos = new ArrayList<>();

    public void adicionaRotuloCaminho(String rotulo) {
        rotulos.add(rotulo);
    }

    public List<String> getRotulos() {
        return this.rotulos;
    }

    public String getProximoRotulo() {
        String proximoRotulo;
        if (this.rotulos.size() > 0) {
            proximoRotulo = this.rotulos.get(this.rotulos.size() - 1);
            this.rotulos.remove(this.rotulos.size() - 1);
        } else {
            proximoRotulo = "";
        }

        return proximoRotulo;
    }
}
