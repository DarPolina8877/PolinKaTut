package com.example.tutpolin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tutpolin.Const.Const
import com.example.tutpolin.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->
            var buttonState = "b"
            if(result.resultCode == RESULT_OK){
                buttonState = result.data?.getStringExtra(Const.BUTTON_STATE)!!
                var text1: String = " "
                var text2: String = " "
                if (buttonState == Const.SIGN_ONE){
                    text1 = result.data?.getStringExtra(Const.SIGN_ONE)!!
                    text2 = result.data?.getStringExtra(Const.SIGN_TWO)!!
                    bind.textView.text = text1
                    bind.textView1.text = text2

                } else if (buttonState == Const.SIGN_TWO){
                    text1 = result.data?.getStringExtra(Const.SIGN_TWO)!!
                    text2 = result.data?.getStringExtra(Const.SIGN_ONE)!!
                    bind.textView.text = text1
                    bind.textView1.text = text2

                }
            }
        }
    }

    fun OnClickTask1(view: View){
        val inten = Intent(this, Second::class.java)
        inten.putExtra(Const.BUTTON_STATE, Const.SIGN_ONE)
        //startActivity(inten)
        launcher?.launch(inten)
    }
    fun OnClickTask2(view: View){
        val inten = Intent(this, Second::class.java)
        inten.putExtra(Const.BUTTON_STATE, Const.SIGN_TWO)
        //startActivity(inten)
        launcher?.launch(inten)
    }
}