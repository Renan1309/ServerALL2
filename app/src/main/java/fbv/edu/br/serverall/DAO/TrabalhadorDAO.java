package fbv.edu.br.serverall.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import fbv.edu.br.serverall.modelo.Trablhador;

/**
 * Created by renan on 15/11/2017.
 */

public class TrabalhadorDAO extends SQLiteOpenHelper {
    public TrabalhadorDAO(Context context) {
        super(context, "BancoTrab", null, 1);
    }

    @Override
    //Sempre que precisar criar obanco de dados chamamos essa classe, acabei de cria oque quero fazer !
    //Execultar a SQL no banco de dados o -SQLiteDatabase db- represent\ o banco
    public void onCreate(SQLiteDatabase db) {
        String sql =" CREATE TABLE Trabalhador (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, email TEXT, profissao TEXT )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Trabalhador";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Trablhador trabalhadores) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("nome", trabalhadores.getNome());
        dados.put("endereco", trabalhadores.getEndereco());
        dados.put("telefone", trabalhadores.getTelefone());
        dados.put("email", trabalhadores.getEmail());
        dados.put("profissao",trabalhadores.getProfissao());
        db.insert("Trabalhador", null, dados);

    }

    public List<Trablhador> buscartrabalhadores() {
        String sql = "SELECT * from Trabalhador;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Trablhador> trabalhadores = new ArrayList<Trablhador>();
        while(c.moveToNext()){
            Trablhador trabalhador = new Trablhador();
            trabalhador.setIg(c.getLong(c.getColumnIndex("id")));
            trabalhador.setNome(c.getString(c.getColumnIndex("nome")));
            trabalhador.setEndereco(c.getString(c.getColumnIndex("endereco")));
            trabalhador.setTelefone(c.getString(c.getColumnIndex("telefone")));
            trabalhador.setEmail(c.getString(c.getColumnIndex("email")));
            trabalhador.setProfissao(c.getString(c.getColumnIndex("profissao")));
           ;
            trabalhadores.add(trabalhador);
        }
                c.close();
        return trabalhadores;
    }
    }

