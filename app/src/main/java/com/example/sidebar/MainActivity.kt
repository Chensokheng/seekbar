package com.example.sidebar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var color1 = 0
    var color2 = 0
    var color3 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar1.max = 255
        seekBar2.max = 255
        seekBar3.max = 255
        class CommonListener:SeekBar.OnSeekBarChangeListener{

            var btn = 0
            constructor(btn:Int){
                this.btn = btn
            }
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                when(p0?.id){
                    R.id.seekBar1 ->{
                        color1 = p1
                    }
                    R.id.seekBar2 ->{
                        color2 = p1
                    }
                    R.id.seekBar3 ->{
                        color3 = p1
                    }
                }

                var color = Color.rgb(color1,color2,color3)
                show.text = "RGB($color1,$color2,$color3)"
                show.setTextColor(Color.rgb(255-color1,255-color2,255-color3))
                if (btn == 1){
                    button.setBackgroundColor(color)
                }
                if (btn == 2){
                    button2.setBackgroundColor(color)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}

        }



        button.setOnClickListener{
            button.setBackgroundColor(Color.rgb(color1,color2,color3))
            var comm = CommonListener(1)
            seekBar1.setOnSeekBarChangeListener(comm)
            seekBar2.setOnSeekBarChangeListener(comm)
            seekBar3.setOnSeekBarChangeListener(comm)
        }

        button2.setOnClickListener {
            button2.setBackgroundColor(Color.rgb(color1,color2,color3))
            var comm = CommonListener(2)
            seekBar1.setOnSeekBarChangeListener(comm)
            seekBar2.setOnSeekBarChangeListener(comm)
            seekBar3.setOnSeekBarChangeListener(comm)
        }
    }



}
