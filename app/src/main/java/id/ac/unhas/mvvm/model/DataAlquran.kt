package id.ac.unhas.mvvm.model

class DataAlquran : ArrayList<Quran>()
//https://api.npoint.io/99c279bb173a6e28359c/data

//DataProvinsiItem = Provinsi
data class Quran(
    val nama: String?,
    val ayat: Int?,
    val urut: Int?,
    val nomor: Int?,
    val asma: String?,
    val arti: String?
)

data class Items(
    val test_name: String?,
    val test_ayat: Int?
)