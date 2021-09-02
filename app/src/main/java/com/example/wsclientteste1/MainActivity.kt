package com.example.wsclientteste1

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSaudar.setOnClickListener {

//            var curso = Curso(edtNome.text.toString(), edtCodigo.text.toString().toInt())
//
//            Fundo(curso).execute()

        }

        btnCep.setOnClickListener {
//            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

            val url = "https://viacep.com.br/ws/"+edtCep.text.toString()+"/json/"

            val resp = Fundo(url).execute().get()

            val a = JSONObject(resp)

            if(!a.isNull("erro")) {
                if(a.getBoolean("erro")) {
                    Toast.makeText(this, "CEP não existe!", Toast.LENGTH_SHORT).show()
                } else {
                    Log.e("OBJ", a.getString("cep"))
                    Log.e("OBJ", a.getString("logradouro"))
                    Log.e("OBJ", a.getString("complemento"))
                    Log.e("OBJ", a.getString("bairro"))
                    Log.e("OBJ", a.getString("localidade"))
                    Log.e("OBJ", a.getString("uf"))
                    Log.e("OBJ", a.getString("ddd"))
                }
            } else {
                Log.e("OBJ", a.getString("cep"))
                Log.e("OBJ", a.getString("logradouro"))
                Log.e("OBJ", a.getString("complemento"))
                Log.e("OBJ", a.getString("bairro"))
                Log.e("OBJ", a.getString("localidade"))
                Log.e("OBJ", a.getString("uf"))
                Log.e("OBJ", a.getString("ddd"))
            }

        }

    }

    class Fundo(url: String) : AsyncTask<Void, Void, String>() {

        val url = url

        override fun doInBackground(vararg params: Void?): String? {
            // a tarefa a ser executada em segundo plano

            val apiResponse = URL(url).readText()

            return apiResponse
        }

        override fun onPreExecute() {
            super.onPreExecute()
            // o que ele deve executar antes de realizar a tarefa

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            // o que ele deve executar após realizar a tarefa

        }
    }
}
