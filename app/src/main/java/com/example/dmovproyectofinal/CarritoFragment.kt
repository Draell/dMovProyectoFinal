package com.example.dmovproyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.dmovproyectofinal.database.Producto
import com.example.dmovproyectofinal.databinding.FragmentCarritoBinding
import org.json.JSONObject

class CarritoFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentCarritoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCarritoBinding.inflate(layoutInflater)
        val argumentoRecibido = arguments?.getString("argumentoPasado")
        binding.textView2.setText(argumentoRecibido)


        //Room

         /* mainViewModel.saveProducto(Producto(
              "1",
              "Camisa",
          "Camisa de manga corta",
              "150",
              "8"
          )) */



        mainViewModel.getProductos()
        mainViewModel.savedProductos.observe(viewLifecycleOwner) {productosList ->
            if(!productosList.isNullOrEmpty()){
                for(producto in productosList){

                    binding.rvCarritoEntries.adapter = CarritoAdapter(productosList)
                    Log.d("estosson",producto.product_name)
                }
            }else{
                Log.d("estosson", "null or empty")
            }
        }


    return binding.root


    }
}