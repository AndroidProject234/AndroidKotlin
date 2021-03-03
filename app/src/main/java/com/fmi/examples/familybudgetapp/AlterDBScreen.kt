package com.fmi.examples.familybudgetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_alter_d_b_screen.*
import kotlinx.android.synthetic.main.fragment_alter_d_b_screen.view.*

class AlterDBScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_alter_d_b_screen, container, false)

        view.homeScreenAlterDBBtn.setOnClickListener{Navigation.findNavController(view).navigate(R.id.action_alterDBScreen_to_mainScreen)}

        var db = context?.let { DataBaseHandler(it) }
        var data = db?.readData()
        if (data != null) {
            for(i in 0..(data.size-1)){
                viewTest.append(data[i].id.toString() + " " + data[i].name + "\n")
            }
        }

        return view
    }

}