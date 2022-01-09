package com.example.passwordgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var passVal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        passVal = findViewById(R.id.passVal)

        val genButton: Button = findViewById(R.id.btGen)
        val charView: TextView = findViewById(R.id.charIn)
        val numView: TextView = findViewById(R.id.numIn)
        val symView: TextView = findViewById(R.id.symIn)

        charView.text = "0"
        numView.text = "0"
        symView.text = "0"
        genButton.setOnClickListener(){
            var numChar: Int = charView.text.toString().toInt()
            var numNum: Int = numView.text.toString().toInt()
            var numSym: Int = symView.text.toString().toInt()
            genPasswd(numChar,numNum,numSym)
        }
    }

    fun genPasswd(numChar: Int, numNum: Int, numSym: Int){
        val charList: Array<String> = arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m",
            "n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I",
            "J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
        val numList: Array<String> = arrayOf("1","2","3","4","5","6","7","8","9","0")
        val symList: Array<String> = arrayOf("!","#","$","%","&","(",")","*","+")
        var generatedPasswd = ""
        repeat(numChar){
            generatedPasswd += charList.random()
        }
        repeat(numNum){
            generatedPasswd += numList.random()
        }
        repeat(numSym){
            generatedPasswd += symList.random()
        }
        if (generatedPasswd!=""){
            var newGen: CharArray = generatedPasswd.toCharArray()
            newGen.shuffle()
            generatedPasswd = newGen.joinToString("")
            Toast.makeText(applicationContext,"Password Generated!",Toast.LENGTH_SHORT).show()
        }
        else{
            generatedPasswd = "Generate your own Password"
            Toast.makeText(applicationContext,"No Input Received",Toast.LENGTH_SHORT).show()
        }
        passVal.text = generatedPasswd
    }
}