package com.example.homeworkfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = resources.getStringArray(R.array.Colors)
        val spinner = findViewById<Spinner>(R.id.spinner)
        var color = "default"
        if (spinner != null) {
            spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    color = colors[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame, ColorFragment.newInstance(color))
                .addToBackStack("ColorFragment")
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else supportFragmentManager.popBackStack()
    }
}