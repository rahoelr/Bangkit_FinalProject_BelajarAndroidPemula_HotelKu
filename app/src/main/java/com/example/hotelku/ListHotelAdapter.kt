package com.example.hotelku

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListHotelAdapter(private val listHotel: ArrayList<Hotel>) : RecyclerView.Adapter<ListHotelAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Hotel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvRate: TextView = itemView.findViewById(R.id.tv_rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hotel, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHotel.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, rate) = listHotel[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.tvRate.text = rate


        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listHotel[holder.adapterPosition])
            val intentDetail = Intent(holder.itemView.context, DetailAct::class.java)
            intentDetail.putExtra("key_hotel", listHotel[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
//        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listHotel[holder.adapterPosition].name, Toast.LENGTH_LONG).show()
//        }
    }


}