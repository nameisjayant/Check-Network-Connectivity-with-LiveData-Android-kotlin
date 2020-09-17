package com.codingwithjks.customlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.codingwithjks.customlivedata.Connectivity.ConnectivityLiveData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var connectivityLiveData:ConnectivityLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectivityLiveData= ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer {isAvailable->
            when(isAvailable)
            {
                true->textView.text="Connected with Internet"
                false-> textView.text="No Network"
            }
        })
    }
}