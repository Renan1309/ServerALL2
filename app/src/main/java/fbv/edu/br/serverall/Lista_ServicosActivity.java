package fbv.edu.br.serverall;

import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import fbv.edu.br.serverall.DAO.TrabalhadorDAO;
import fbv.edu.br.serverall.converter.TrabalhadorConverter;
import fbv.edu.br.serverall.modelo.Trablhador;

public class Lista_ServicosActivity extends AppCompatActivity {

    private ListView listaServicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__servicos);
        listaServicos = (ListView) findViewById(R.id.Lista_servico);
        Button opcao = (Button) findViewById(R.id.opcao);
        opcao.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intentVaipraopcao = new Intent(Lista_ServicosActivity.this, NavegandoEmOpcoesActivity.class);
                startActivity(intentVaipraopcao);
            }
        });

        /**
         listaServicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent newActivity;
        switch (position) {
        case 0:
        newActivity = new Intent(Lista_ServicosActivity.this, EletricistaActivity.class);
        startActivity(newActivity);
        break;

        case 1:
        newActivity = new Intent(Lista_ServicosActivity.this, Pedreiro_Activity.class);
        startActivity(newActivity);
        break;
        case 2:
        newActivity = new Intent(Lista_ServicosActivity.this, PintorActivity.class);
        startActivity(newActivity);
        break;
        case 3:
        newActivity = new Intent(Lista_ServicosActivity.this, EncanadorActivity.class);
        startActivity(newActivity);
        break;
        case 4:
        newActivity = new Intent(Lista_ServicosActivity.this, ArquitetoActivity.class);
        startActivity(newActivity);
        break;
        case 5:
        newActivity = new Intent(Lista_ServicosActivity.this, EngenheiroActivity.class);
        startActivity(newActivity);
        break;
        case 6:
        newActivity = new Intent(Lista_ServicosActivity.this, MacineiroActivity.class);
        startActivity(newActivity);
        break;
        case 7:
        newActivity = new Intent(Lista_ServicosActivity.this, SerralheiroActivity.class);
        startActivity(newActivity);
        break;
        }
        }
        });
         **/
       registerForContextMenu(listaServicos);
    }

    private void carregaLista() {
        TrabalhadorDAO dao = new TrabalhadorDAO(this);
        List<Trablhador> trabalhadores = dao.buscartrabalhadores();
        dao.close();


        // String[] servicos = {"Eletricista", "Pedreiro", "Pintor", "Encanador", "Arquiteto", "Engenheiro", "Marcineiro", "Serralheiro"};


        ArrayAdapter<Trablhador> adpter = new ArrayAdapter<Trablhador>(this, android.R.layout.simple_list_item_1, trabalhadores);
        listaServicos.setAdapter(adpter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_trabalhador, menu);
        return true;    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_enviar_trabalhador:

                TrabalhadorDAO dao = new TrabalhadorDAO(this);
                List<Trablhador> trabalhadores = dao.buscartrabalhadores();
                dao.close();

                TrabalhadorConverter conversor = new TrabalhadorConverter();
                String json = conversor.converteParaJSON(trabalhadores);



                WebClient client = new WebClient();
                String resposta = client.post(json);
                Toast.makeText(this, resposta, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Enviando Trabalhador...", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final  Trablhador trabalhador =  (Trablhador) listaServicos.getItemAtPosition(info.position);

        MenuItem itemSMS = menu.add("Enviar SMS");
        Intent intentSMS = new Intent(Intent.ACTION_VIEW);
        intentSMS.setData(Uri.parse("sms:"+ trabalhador.getTelefone()));
        itemSMS.setIntent(intentSMS);

        MenuItem itemMapa = menu.add("Ver localização do escritorio ");
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + trabalhador.getEndereco()));
        itemMapa.setIntent(intentMapa);


        MenuItem itemSite = menu.add("Visitar Facebook");
        Intent intentSite = new Intent(Intent.ACTION_VIEW);
        String site = trabalhador.getEmail();
        if(!site.startsWith("http://")){
            site ="http://"+site;
        }
        intentSite.setData(Uri.parse(site));
        itemSite.setIntent(intentSite);


        }
    }


