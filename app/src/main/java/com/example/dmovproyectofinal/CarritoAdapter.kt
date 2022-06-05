package com.example.dmovproyectofinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.dmovproyectofinal.database.Producto
import com.example.dmovproyectofinal.databinding.ItemPcarritoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.json.JSONObject

private lateinit var database: DatabaseReference
class CarritoAdapter (private val pcarrito: List<Producto>): RecyclerView.Adapter<CarritoAdapter.CarritoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoAdapter.CarritoHolder {
        val binding = ItemPcarritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarritoHolder(binding)
    }

    override fun onBindViewHolder(holder: CarritoHolder, position: Int) {
        holder.render(pcarrito[position])
    }

    override fun getItemCount(): Int = pcarrito.size

    class CarritoHolder(val binding: ItemPcarritoBinding): RecyclerView.ViewHolder(binding.root){
        fun render(producto: Producto){

            binding.tvNombreProd.setText(producto.product_name)
            binding.tvDescrip.setText(producto.product_description)
            binding.tvPrecio.setText(producto.product_price)
            binding.ivProducto.setImageResource(R.drawable.ic_producto)


        }
    }
}