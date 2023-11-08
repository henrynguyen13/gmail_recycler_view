package com.example.gmail_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
class Adapter (private val items: ArrayList<GmailModel>): RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageAvatar: ImageView = itemView.findViewById(R.id.imgAvatar)

        val imageMark: ImageView = itemView.findViewById(R.id.imgMark)
        private val sender: TextView = itemView.findViewById(R.id.txtSender)
        private val title: TextView = itemView.findViewById(R.id.txtTitle)
        private val content: TextView = itemView.findViewById(R.id.txtContent)
        private val time: TextView = itemView.findViewById(R.id.txtTime)

        fun bind(gmailModel: GmailModel) {
            Glide.with(itemView).load(gmailModel.logoPath).centerCrop()
                .placeholder(R.drawable.ic_launcher_background).into(imageAvatar)
            sender.text = gmailModel.sender
            title.text = gmailModel.title
            content.text = gmailModel.content
            time.text = gmailModel.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val views = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(views)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gmail = items[position]
        holder.bind(gmail)
    }
}