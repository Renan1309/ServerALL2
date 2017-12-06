package fbv.edu.br.serverall;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import fbv.edu.br.serverall.DAO.TrabalhadorDAO;
import fbv.edu.br.serverall.modelo.Trablhador;

public class Trabalhar_AllActivity extends AppCompatActivity {

    private String caminhoFoto;
    private FormularioDados  dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhar__all);
        dados = new FormularioDados(this);
        Button botaoFoto = (Button) findViewById(R.id.formulario_botao_foto);
        botaoFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                caminhoFoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
                File arquivoFoto = new File(caminhoFoto);


                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        FileProvider.getUriForFile(Trabalhar_AllActivity.this, BuildConfig.APPLICATION_ID + ".provider", arquivoFoto));


                startActivityForResult(intent, 123);
            }


        });
        Button satisfacao = (Button) findViewById(R.id.confirmar_registros);
        satisfacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Trablhador trabalhadores = dados.pegarTrabalhador();
                TrabalhadorDAO dao = new TrabalhadorDAO(Trabalhar_AllActivity.this);

                dao.insere(trabalhadores);
                dao.close();

                Toast.makeText(Trabalhar_AllActivity.this, "Trabalhador : " + trabalhadores.getNome() +" Salvo !", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 123) {
                ImageView foto = (ImageView)findViewById(R.id.formulario_foto);
                Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
                Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap,300,300,true);
                foto.setImageBitmap(bitmapReduzido);
                foto.setScaleType(ImageView.ScaleType.FIT_XY);
            }

            }

            }
    }

