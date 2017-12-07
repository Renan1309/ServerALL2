package fbv.edu.br.serverall;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import fbv.edu.br.serverall.DAO.TrabalhadorDAO;
import fbv.edu.br.serverall.converter.TrabalhadorConverter;
import fbv.edu.br.serverall.modelo.Trablhador;

/**
 * Created by renan on 06/12/2017.
 */

public class EnviarTrabalhadoresTask extends AsyncTask<Object , Object , String>{
    private Context context;

    public EnviarTrabalhadoresTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Object...params) {
        TrabalhadorDAO dao = new TrabalhadorDAO(context);
        List<Trablhador> trabalhadores = dao.buscartrabalhadores();
        dao.close();

        TrabalhadorConverter conversor = new TrabalhadorConverter();
        String json = conversor.converteParaJSON(trabalhadores);



        WebClient client = new WebClient();
        String resposta = client.post(json);
       // Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        Toast.makeText(context, (String)resposta, Toast.LENGTH_LONG).show();
    }
}
