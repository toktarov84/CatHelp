package com.example.manual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.manual.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val titles = listOf(
        "00. Начало",
        "01. Чем кормить кота",
        "02. Как гладить кота",
        "03. Как спит кот",
        "04. Как играть с котом",
        "05. Как разговаривать с котом",
        "06. Интересные факты из жизни котов",
        "07. Как назвать кота"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            listView.adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, titles)
            listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent2 = Intent(this@MainActivity, MainActivity2::class.java)
                intent2.putExtra("title", position)
                startActivity(intent2)
            }
        }
    }
}