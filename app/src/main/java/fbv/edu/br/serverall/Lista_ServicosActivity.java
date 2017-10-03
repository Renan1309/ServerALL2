package fbv.edu.br.serverall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Lista_ServicosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__servicos);

        String[] servicos = {"Eletricista", "Pedreiro", "Pintor", "Encanador", "Arquiteto", "Engenheiro", "Marcineiro", "Serralheiro"};

        ListView listaServicos = (ListView) findViewById(R.id.Lista_servico);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, servicos);
        listaServicos.setAdapter(adpter);
        Button opcao = (Button) findViewById(R.id.opcao);
        opcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaipraopcao = new Intent(Lista_ServicosActivity.this, NavegandoEmOpcoesActivity.class);
                startActivity(intentVaipraopcao);
            }
        });
        listaServicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity;
                switch (position) {
                    case 0:
                        newActivity = new Intent(Lista_ServicosActivity.this, EletricistaActivity.class);
                        startActivity(newActivity);
                }
            }
        });

    }


}
