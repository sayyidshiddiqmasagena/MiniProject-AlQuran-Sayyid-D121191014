package id.ac.unhas.mvvm.ui.alquran
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.mvvm.R
import id.ac.unhas.mvvm.model.Quran

class Adapter(private val exampleList: ArrayList<Quran>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_quran, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.textView1.text = "${currentItem.nomor}. ${currentItem.nama}"+
                                "   ${currentItem.asma}"
    }

    override fun getItemCount() = exampleList.size

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.findViewById(R.id.text_here)
        //val cardView: RelativeLayout? = itemView.cardView


    }
}