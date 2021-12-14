package id.ac.unhas.mvvm.model

data class test(
    val units: List<Unit>
)

data class Unit(
    val age: String,
    val armor: String,
    val build_time: Int,
    val description: String,
    val hit_points: Int,
    val id: Int,
    val line_of_sight: Int,
    val movement_rate: Double,
    val name: String
)