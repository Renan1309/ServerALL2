package fbv.edu.br.serverall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Pedreiro_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedreiro_);

        String[] Pedreiro = {"Miranda gomes", "Neto Barbosa", "Gustavo Bueno", "Lucas Romero", "Rogrido Neves"};
        ListView listaePedreiros = (ListView) findViewById(R.id.Lista_Pedreiros);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Pedreiro);
        listaePedreiros.setAdapter(adpter);
        registerForContextMenu(listaePedreiros);
        listaePedreiros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity;
                switch (position) {
                    case 0:
                        newActivity = new Intent(Pedreiro_Activity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                }
            }

        });
    }
}
