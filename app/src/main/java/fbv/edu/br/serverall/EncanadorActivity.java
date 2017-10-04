package fbv.edu.br.serverall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EncanadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encanador);
        String[] Encanador = {"Josias Cunha", "Neto Barbosa", "Gustavo Bueno", "Lucas Romero", "Rogrido Neves"};
        ListView listaeEncanador = (ListView) findViewById(R.id.Lista_encanador);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Encanador);
        listaeEncanador.setAdapter(adpter);
        registerForContextMenu(listaeEncanador);
        listaeEncanador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity;
                switch (position) {
                    case 0:
                        newActivity = new Intent(EncanadorActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        newActivity = new Intent(EncanadorActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                        break;
                    case 2:
                        newActivity = new Intent(EncanadorActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                        break;
                    case 3:
                        newActivity = new Intent(EncanadorActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                        break;
                }
            }

        });
    }
}
