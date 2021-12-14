package id.ac.unhas.mvvm.ui.alquran

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.unhas.mvvm.R
import id.ac.unhas.mvvm.utilities.StaticData
import kotlinx.android.synthetic.main.detail_fragment.*

class detailFragment : Fragment() {

    companion object {
        fun newInstance() = detailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailed_text.text = "Nama surah : ${StaticData.nama}  ${StaticData.asma}\n\n"+
                             "Arti                : ${StaticData.arti} \n\n" +
                             "Surah-ke      : ${StaticData.nomor}\n\n"+
                             "Jumlah ayat : ${StaticData.ayat}"


        shareIcon.setOnClickListener{
            val nama = StaticData.nama
            val arti = StaticData.arti
            val urut = StaticData.urut
            val asma = StaticData.asma
            val ayat = StaticData.ayat
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT, "Udah baca Al-Quran belum? " +
                        "yuk baca surah ${nama}, detailnya ada dibawah ya!\n\n"+
                        "Surah ${nama}  ${asma}\n\n"+
                        "Arti : ${arti}\n"+
                        "Surah-ke : ${urut}\n"+
                        "Jumlah ayat : ${ayat}\n"
                )
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }
    }

}