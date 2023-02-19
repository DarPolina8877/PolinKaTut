package com.example.tutpolin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tutpolin.Const.Const
import com.example.tutpolin.databinding.ActivitySecondBinding


class Second : AppCompatActivity() {
    lateinit var bind: ActivitySecondBinding
    var buttonState = "b"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bind.root)

        buttonState = intent.getStringExtra(Const.BUTTON_STATE)!!
        if (buttonState == Const.SIGN_ONE) {
            bind.edTask1.visibility = View.VISIBLE

        } else if (buttonState == Const.SIGN_TWO){
            bind.edTask2.visibility = View.VISIBLE
        }
    }
    fun OnClickGone(view: View){
        if(buttonState == Const.SIGN_ONE){
            val i = Intent()
            i.putExtra(Const.BUTTON_STATE, Const.SIGN_ONE)
            i.putExtra(Const.SIGN_ONE, bind.edTask1.text.toString())
            i.putExtra(Const.SIGN_TWO, "Кнопка 2 не задействована")
            setResult(RESULT_OK, i)
            finish()
        } else if(buttonState == Const.SIGN_TWO){
            val i = Intent()
            i.putExtra(Const.BUTTON_STATE, Const.SIGN_TWO)
            i.putExtra(Const.SIGN_TWO, bind.edTask2.text.toString())
            i.putExtra(Const.SIGN_ONE, "Кнопка 1 не задействована")
            setResult(RESULT_OK, i)
            finish()
        }
    }

}