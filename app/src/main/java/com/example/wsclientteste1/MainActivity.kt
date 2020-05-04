package com.example.wsclientteste1

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSaudar.setOnClickListener {

            Fundo(edtNome.text.toString()).execute()

        }

    }

    class Fundo(pessoa: String?) : AsyncTask<Void, Void, String>() {

        val nome = pessoa

        var saudacao : String? = null

        override fun doInBackground(vararg params: Void?): String? {
            // a tarefa a ser executada em segundo plano

            saudacao = ClientSaudacao().receberSaudacao(nome)

            Log.e("Saída", saudacao)

            return null
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
