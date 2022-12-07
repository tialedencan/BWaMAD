package com.tia.orwma_lv7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MakeupRecyclerAdapter(private val items: List<Makeup>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //private var items:List<Makeup> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MakeupViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_content,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MakeupViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

   /* fun postItemsList(data: ArrayList<Makeup>){
        items = data
    }
   */

    class MakeupViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photoImage:ImageView = itemView.findViewById(R.id.makeupPhoto)
        private val  makeupName:TextView = itemView.findViewById(R.id.makeupName)
        private val makeupPrice:TextView = itemView.findViewById(R.id.makeupPrice)
        private val makeupRating :TextView = itemView.findViewById(R.id.makeupRating)
        private val makeupDescription:TextView = itemView.findViewById(R.id.makeupDescription)

        fun bind(makeup:Makeup){
            Glide
                .with(itemView.context)
                .load(makeup.image_link)
                .into(photoImage)
            makeupName.text=makeup.name
            makeupPrice.text=makeup.price
            makeupRating.text=makeup.rating.toString()
            makeupDescription.text=makeup.description
        }
    }
}





