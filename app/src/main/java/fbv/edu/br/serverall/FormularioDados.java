package fbv.edu.br.serverall;

import android.widget.EditText;

import fbv.edu.br.serverall.modelo.Trablhador;

/**
 * Created by renan on 15/11/2017.
 */

public class FormularioDados {
    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefne;
    private final EditText campoEmail;
    private final EditText campoProfissao;

    public FormularioDados(Trabalhar_AllActivity activity){
        campoNome = (EditText) activity.findViewById(R.id.formulario_nomedotrabalhador) ;
        campoEndereco= (EditText) activity.findViewById(R.id.formulario_endereco);
        campoTelefne = (EditText)activity.findViewById(R.id.formulario_endereco);
        campoEmail= (EditText) activity.findViewById(R.id.formulario_email);
        campoProfissao=(EditText) activity.findViewById(R.id.formulario_profissao);

    }

    public Trablhador pegarTrabalhador() {
        Trablhador trabalhador = new Trablhador();

        trabalhador.setNome(campoNome.getText().toString());
        trabalhador.setEndereco(campoEndereco.getText().toString());
        trabalhador.setTelefone(campoTelefne.getText().toString());
        trabalhador.setEmail(campoEmail.getText().toString());
        trabalhador.setProfissao((campoProfissao.getText().toString()));
        return  trabalhador;
    }
}
