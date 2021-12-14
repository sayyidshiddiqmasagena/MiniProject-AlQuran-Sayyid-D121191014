package id.ac.unhas.mvvm.utilities

import id.ac.unhas.mvvm.model.Quran

class StaticData {
    companion object{
        var nama: String = ""
        var asma: String = ""
        var arti: String = ""
        var nomor: Int = 0
        var ayat: Int = 0
        var urut: Int = 0

        fun fill(quran: Quran){
            if(quran.nama != null){
                nama =  quran.nama
            } else{
                nama = " - "
            }
            if(quran.arti != null){
                arti =  quran.arti
            } else{
                arti = " - "
            }
            if(quran.nomor != null){
                nomor = quran.nomor
            } else{
                nomor = 0
            }
            if(quran.asma != null){
                asma = quran.asma
            } else{
                asma = " - "
            }
            if(quran.urut != null){
                urut = quran.urut
            } else{
                urut = 0
            }
            if(quran.ayat != null){
                ayat = quran.ayat
            } else{
                ayat = 0
            }
        }
    }
}