package id.ac.unhas.mvvm.ui.alquran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.mvvm.R
import id.ac.unhas.mvvm.model.Quran
import kotlinx.android.synthetic.main.recyclerview_item_quran.view.*

class shareAdapter(private val exampleList: ArrayList<Quran>, val listener: OnItemClickListener)
    : RecyclerView.Adapter<shareAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onClick(quran: Quran)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shareAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_quran, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: shareAdapter.ViewHolder, position: Int) {
        holder.bind(exampleList[position], listener)
    }

    override fun getItemCount() = exampleList.size


    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(quran: Quran, listener: OnItemClickListener) {
            with(itemView) {
                text_here.text = "${quran.nomor}. ${quran.nama}" +
                        "   ${quran.asma}"
            }
            itemView.setOnClickListener {
                listener.onClick(quran)
            }
        }
    }
}