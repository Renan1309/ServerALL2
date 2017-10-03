package fbv.edu.br.serverall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EletricistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eletricista);
        String[] Eletricistas = {"Paulo Bento", "José Miranda", "Gustavo Bueno", "Lucas Romero", "Rogrido Neves"};
        ListView listaeletricista = (ListView) findViewById(R.id.Lista_eletricista);
        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Eletricistas);
        listaeletricista.setAdapter(adpter);
        registerForContextMenu(listaeletricista);
        listaeletricista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity;
                switch (position) {
                    case 0:
                        newActivity = new Intent(EletricistaActivity.this, InformacoesActivity.class);
                        startActivity(newActivity);
                }
            }

        });
    }
}



