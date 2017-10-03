package fbv.edu.br.serverall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        Button entrar = (Button) findViewById(R.id.botao_entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vaiparalistardeservicos = new Intent(InicialActivity.this, Lista_ServicosActivity.class);
                startActivity(vaiparalistardeservicos);
            }
        });
    }
}
