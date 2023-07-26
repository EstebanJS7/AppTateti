package com.example.apptateti

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var img1: ImageView?=null
    var img2: ImageView?=null
    var img3: ImageView?=null
    var img4: ImageView?=null
    var img5: ImageView?=null
    var img6: ImageView?=null
    var img7: ImageView?=null
    var img8: ImageView?=null
    var img9: ImageView?=null

    var imgTurnoX: ImageView?=null
    var imgTurnoO: ImageView?=null
    var turno = "x"
    val listaImagenes = listOf(R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9)
    var matrizGanadora = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9),
        intArrayOf(1,4,7),
        intArrayOf(2,5,8),
        intArrayOf(3,6,9),
        intArrayOf(1,5,9),
        intArrayOf(3,5,7)
    )
    var posicionesX=IntArray(5)
    var posicionesO=IntArray(5)
    var ganador=""
    var contadorX=0
    var contadorO=0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img1=findViewById(R.id.img1)
        img2=findViewById(R.id.img2)
        img3=findViewById(R.id.img3)
        img4=findViewById(R.id.img4)
        img5=findViewById(R.id.img5)
        img6=findViewById(R.id.img6)
        img7=findViewById(R.id.img7)
        img8=findViewById(R.id.img8)
        img9=findViewById(R.id.img9)
        imgTurnoX=findViewById(R.id.imgTurnoX)
        imgTurnoO=findViewById(R.id.imgTurnoO)
        imgTurnoX?.setBackgroundColor(Color.RED)

    }
    fun clickImage(view: View){
        for (i in listaImagenes.indices) {
            if (view.id == listaImagenes[i]) {
                if (turno == "x") {
                    posicionesX[contadorX] = i + 1
                    contadorX++
                } else {
                    posicionesO[contadorO] = i + 1
                    contadorO++
                }
            }
        }
        if(turno == "x"){
            view.setBackgroundResource(R.drawable.x)
            imgTurnoO?.setBackgroundColor(Color.RED)
            imgTurnoX?.setBackgroundColor(Color.WHITE)
            turno = "o"
        }else{
            view.setBackgroundResource(R.drawable.o)
            imgTurnoX?.setBackgroundColor(Color.RED)
            imgTurnoO?.setBackgroundColor(Color.WHITE)
            turno = "x"
        }
        for(i in 0 until contadorX){
            var gano=true
            var altoMatriz=matrizGanadora.size
            for(j in 0 until altoMatriz){
                gano=coincideGanador(matrizGanadora[j], posicionesX)
                if(gano==true){
                    Toast.makeText(this, "Gano X", Toast.LENGTH_LONG).show()
                    ganador="x"
                    dibujarGanador()
                    deshabilitar()
                    break
                }
            }
            if(gano==true){
                break
            }
        }
        for(i in 0 until contadorO){
            var gano=true
            var altoMatriz=matrizGanadora.size
            for(j in 0 until altoMatriz){
                gano=coincideGanador(matrizGanadora[j], posicionesO)
                if(gano==true){
                    Toast.makeText(this, "Gano O", Toast.LENGTH_LONG).show()
                    ganador = "o"
                    dibujarGanador()
                    deshabilitar()
                    break
                }
            }
            if(gano==true){
                break
            }
        }
        view.isEnabled=false
    }
    fun coincideGanador(registroGanador: IntArray, posiciones: IntArray): Boolean{
        for (i in 0 until 3){
            if(registroGanador[i]!=posiciones[i]){
                return false
            }
        }
        return true
    }
    fun dibujarGanador(){
        if(ganador=="x"){
            for (i in 0 until contadorX){
                if(posicionesX[i]==1){
                    img1?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==2){
                    img2?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==3){
                    img3?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==4){
                    img4?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==5){
                    img5?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==6){
                    img6?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==7){
                    img7?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==8){
                    img8?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesX[i]==9){
                    img9?.setBackgroundColor(Color.BLUE)
                }
            }
        }
        if(ganador=="o"){
            for (i in 0 until contadorO){
                if(posicionesO[i]==1){
                    img1?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==2){
                    img2?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==3){
                    img3?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==4){
                    img4?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==5){
                    img5?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==6){
                    img6?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==7){
                    img7?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==8){
                    img8?.setBackgroundColor(Color.BLUE)
                }
                if(posicionesO[i]==9){
                    img9?.setBackgroundColor(Color.BLUE)
                }
            }
        }
    }
    fun deshabilitar(){
        img1?.isEnable=false
        img2?.isEnable=false
        img3?.isEnable=false
        img4?.isEnable=false
        img5?.isEnable=false
        img6?.isEnable=false
        img7?.isEnable=false
        img8?.isEnable=false
        img9?.isEnable=false
    }
    fun reiniciar(view: View){
        val intento=intent
        finish()
        startActivity()
    }
}
