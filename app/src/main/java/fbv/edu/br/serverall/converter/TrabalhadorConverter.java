package fbv.edu.br.serverall.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import fbv.edu.br.serverall.modelo.Trablhador;

/**
 * Created by renan on 06/12/2017.
 */

public class TrabalhadorConverter {

    public String converteParaJSON(List<Trablhador> trabalhadores) {

        JSONStringer js = new JSONStringer();

        try {
            js.object().key("list").array().object().key("trabalhador").array();
            for (Trablhador aluno : trabalhadores) {
                js.object();
                js.key("nome").value(aluno.getNome());
                js.key("profissao").value(aluno.getProfissao());
                js.endObject();
            }

            js.endArray().endObject().endArray().endObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
