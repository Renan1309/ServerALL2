package fbv.edu.br.serverall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EngenheiroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engenheiro);
        String[] Engenheiro = {"Josias Cunha", "Neto Barbosa", "Gustavo Bueno", "Lucas Romero", "Rogrido Neves"};
        ListView listaeEngenheiros = (ListView) findViewById(R.id.Lista_engenheiros);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Engenheiro);
        listaeEngenheiros.setAdapter(adpter);
        registerForContextMenu(listaeEngenheiros);
        listaeEngenheiros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity;
                switch (position) {
                    case 0:
                        newActivity = new Intent(EngenheiroActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                }
            }

        });
    }
}
