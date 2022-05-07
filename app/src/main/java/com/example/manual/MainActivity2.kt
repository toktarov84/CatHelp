package com.example.manual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.manual.databinding.ActivityMain2Binding
import java.lang.Exception

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val resName = "n" + intent.getIntExtra("title", 0)
            val resIdentifier = resources.getIdentifier(resName, "raw", "com.example.manual")
            val text = resources.openRawResource(resIdentifier).reader().readText()

            binding.webView.loadDataWithBaseURL(null, text, "text/html", "en_US", null)
        } catch (e: Exception) {}
    }
}