package com.kseyko.sampleshopping

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kseyko.sampleshopping.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), CustomDialog.OnFragmentCallbacks {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var favState = false

        binding.favImgBtn.setOnClickListener {
            if (favState) {
                binding.favImgBtn.setImageResource(R.drawable.ic_favorite_on)

            } else {
                binding.favImgBtn.setImageResource(R.drawable.ic_favorite_off)
            }
            favState = !favState
        }

        binding.notifyImgBtn.setOnClickListener {
            showDialog()
        }

    }

    private fun showDialog() {
        CustomDialog().show(supportFragmentManager, "MyCustomFragment")
    }

    override fun changeImage(isChange: Boolean) {
                if (isChange) binding.notifyImgBtn.setImageResource(R.drawable.ic_notifications_on)
                else binding.notifyImgBtn.setImageResource(R.drawable.ic_notifications_off)
    }

//    override fun changeImage(isChange: Boolean) {
//        if (isChange) binding.notifyImgBtn.setImageResource(R.drawable.ic_notifications_on)
//        else binding.notifyImgBtn.setImageResource(R.drawable.ic_notifications_off)
//    }

}

