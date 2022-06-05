package com.example.dmovproyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dmovproyectofinal.databinding.FragmentHomeBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONObject

class HomeFragment : Fragment() {
private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        val baseDatos = Firebase.database
        val myReff = baseDatos.reference


        myReff.child("Usuarios").child("1").get().addOnSuccessListener { record ->
            //Log.d("fire", "${record.value}")
            val yeison = JSONObject(record.value.toString())

            binding.tvUserPlace.setText(yeison.getString("User").toString())
            binding.tvLevelPlace.setText(yeison.getString("Level").toString())
            binding.tvDatePlace.setText(yeison.getString("Date").toString())
            binding.tvArtPlace.setText(yeison.getString("Art").toString())
        }


        //action_homeFragment_to_insideHome
        val navController = findNavController()
        binding.btnHomeToCarrito.setOnClickListener{
            //navController.navigate(R.id.action_homeFragment_to_insideHome)
        //    val testArgument = "desde el home"
            val directions = HomeFragmentDirections.actionHomeFragmentToCarritoFragment(/*estArgument*/)
            navController.navigate(directions)
        }

        return binding.root
    }
}