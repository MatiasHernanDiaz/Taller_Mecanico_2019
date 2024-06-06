class Auto(
    val patente: String,
    val cliente: Persona,
    val kilometraje: Int,
    val marca: String,
    val modelo: String,
    var estadoMotor: Boolean,
    var descasteSupenDelantera: Double,
    var descasteSupenTrasera: Double,
    var descasteCubierta: Double
) {
}