package com.fmi.examples.familybudgetapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_alter_d_b_screen.*
import java.util.*


class AlterDBScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alter_d_b_screen)
        val db = DataBaseHandler(this)
        val data = db.readData()
        val arrayList = ArrayList<String>()
        var arrayAdapter: ArrayAdapter<String>  = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            arrayList
        )
        for(i in 0 until data.size) {
            var s = ""
            s = if(data[i].isIncome == 0) "Разход"
            else "Приход"
            arrayList.add(
                data[i].id.toString() + ": Име: " + data[i].name + " \n"
                        + s + ": " + data[i].amount + " лв" + " \n"
                        + data[i].day + " \n" + data[i].month + " \n" + s
            )
        }
        val listView = findViewById<ListView>(R.id.listView1);

        listView.adapter = arrayAdapter;
        
        listView.setOnItemClickListener { _, _, position, _ ->
            val name = arrayAdapter.getItem(position).toString()
            val intent = Intent(this, UpdateDeleteActivity::class.java)
            intent.putExtra("Name", name)
            startActivity(intent)
        }

        homeScreenAlterDBBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}