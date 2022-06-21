package com.ebookfrenzy.pinchgesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ScaleGestureDetector
import com.ebookfrenzy.pinchgesture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    var scaleGestureDetector: ScaleGestureDetector? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        scaleGestureDetector = ScaleGestureDetector(this, MyOnScaleGestureListener())
    }

    inner class MyOnScaleGestureListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            val scaleFactor = detector?.scaleFactor
            if (scaleFactor != null) {
                if (scaleFactor > 1){
                    binding.myTextView.text = "Zooming Out"
                }else{
                    binding.myTextView.text = "Zooming In"
                }
            }
            return true
        }

        override fun onScaleBegin(p0: ScaleGestureDetector?): Boolean {
            return true
        }

        override fun onScaleEnd(p0: ScaleGestureDetector?) {

        }

    }
}