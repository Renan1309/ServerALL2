package fbv.edu.br.serverall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SerralheiroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serralheiro);
        String[] Serralheiro = {"Josias Cunha", "Neto Barbosa", "Gustavo Bueno", "Lucas Romero", "Rogrido Neves"};
        ListView listaeSerralheiro= (ListView) findViewById(R.id.Lista_serralheiros);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Serralheiro);
        listaeSerralheiro.setAdapter(adpter);
        registerForContextMenu(listaeSerralheiro);
        listaeSerralheiro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity;
                switch (position) {
                    case 0:
                        newActivity = new Intent(SerralheiroActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        newActivity = new Intent(SerralheiroActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                        break;
                    case 2:
                        newActivity = new Intent(SerralheiroActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                        break;
                    case 3:
                        newActivity = new Intent(SerralheiroActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                        break;

                }
            }

        });
    }
}
