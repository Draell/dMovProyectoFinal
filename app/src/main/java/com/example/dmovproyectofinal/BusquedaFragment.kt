package com.example.dmovproyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.dmovproyectofinal.database.Producto
import com.example.dmovproyectofinal.databinding.ActivityMainBinding
import com.example.dmovproyectofinal.databinding.FragmentBusquedaBinding
import org.json.JSONObject

class BusquedaFragment : Fragment() {
private lateinit var queue: RequestQueue
private lateinit var binding: FragmentBusquedaBinding
private val MainViewModel:MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBusquedaBinding.inflate(layoutInflater)

        //Volley
        queue = Volley.newRequestQueue(context)
        binding.btnFind.setOnClickListener{
            val idArt = binding.etSearch.text.toString()
        getArticulo(idArt)
        }
        //getArticulo(2)

        binding.btnSave.setOnClickListener{
            MainViewModel.saveProducto(Producto(
                binding.tvBuscadoId.text.toString(),
                binding.tvBuscadoTitle.text.toString(),
                binding.tvBuscadoDesc.text.toString(),
                binding.tvBuscadoPrice.text.toString(),
                binding.tvBuscadoPrice.text.toString()
            )
            )
            MainViewModel.getProductos()
            MainViewModel.savedProductos.observe(viewLifecycleOwner){productList ->
                if(!productList.isNullOrEmpty()){
                    for(producto in productList){
                        Log.d("sad","${producto.idProd}")
                    }
                }
            }
        }



return binding.root
    }
    fun getArticulo(idArticulo: String){
        //val url = "https://pokeapi.co/api/v2/pokemon/${idArticulo}"
        val url = "https://fakestoreapi.com/products/${idArticulo}"

        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response ->
            Log.i( "JSONRESPONSE", response.toString())

            binding.tvBuscadoId.setText(response.getString("id").replaceFirstChar { it.uppercaseChar() })
            binding.tvBuscadoTitle.setText(response.getString("title").replaceFirstChar { it.uppercaseChar() })
            binding.tvBuscadoPrice.setText(response.getString("price").replaceFirstChar { it.uppercaseChar() })
            binding.tvBuscadoCateg.setText(response.getString("category").replaceFirstChar { it.uppercaseChar() })
            binding.tvBuscadoDesc.setText(response.getString("description").replaceFirstChar { it.uppercaseChar() })

        },
            Response.ErrorListener{ error ->
                Log.w("JSONRESPONSE",error.message as String)
            })
        queue.add(jsonRequest)
    }


    override fun onStop(){
        super.onStop()
        queue.cancelAll("Stopped")
    }
}


