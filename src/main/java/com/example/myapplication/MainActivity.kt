package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /* savedInstanceState - armazena os dados da aplicação para que eventualmente se for fechada os dados não sejam perdidos, facilitando a recriação da tela quando a aplicação for iniciada novamente  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* esse método define qual é o layout da aplicação  */
        setContentView(R.layout.activity_main)
        Log.i("lifeCycle", "onCreate")

        val btnClickHere = findViewById<Button>(R.id.btn_click_here)
        val edtName = findViewById<EditText>(R.id.edt_name)
        val txvResult = findViewById<TextView>(R.id.txv_result)

        btnClickHere.setOnClickListener{
            val name: String = edtName.editableText.toString()
            txvResult.text = name
        }

        val btnOpenWebsite = findViewById<Button>(R.id.btn_open_website)
        val btnOpenOtherActivity = findViewById<Button>(R.id.btn_open_nxt_atv)
        val btnOpenLoginActivity = findViewById<Button>(R.id.btn_open_login_atv)

        /* chamada implícita de uma Activity */
        btnOpenWebsite.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mathcoimbra"))
            startActivity(i)
        }

        /* chamada explícita de uma Activity */
        /* packageContext - informado qual é activity que irá passar para outra activity, no caso abaixo é essa activity, portanto, this */
        /* NextActivity::class.java - passa a classe instanciada para Intent */
        btnOpenOtherActivity.setOnClickListener{
            val i = Intent(this, OtherActivity::class.java)
            startActivity(i)
        }

        btnOpenLoginActivity.setOnClickListener{
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

    }

    fun onClickHere(view: View){
        /* Toast - balão que aparece na tela com uma mensagem */
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }

    /* Métodos de ciclo de vida */

    override fun onStart(){
        super.onStart()
        Log.i("lifeCycle", "onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.i("lifeCycle", "onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.i("lifeCycle", "onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i("lifeCycle", "onStop")
    }

    override fun onRestart(){
        super.onRestart()
        Log.i("lifeCycle", "onRestart")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("lifeCycle", "onDestroy")
    }

}