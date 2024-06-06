class Auto(
    val patente: String,
    val cliente: Persona,
    val kilometraje: Int,
    val marca: String,
    val modelo: String,
    var estadoMotor: Boolean,
    var descasteSupenDelantera: Double,
    var descasteSupenTrasera: Double,
    var descasteCubierta: Double,
    var ruedas: MutableList<Rueda>,
    val motor: Motor
) {
}

data class Rueda(var dibujo : Int) {}
class Motor {
    lateinit var carController : CarController

    fun regularBujias(numeroBujia : Int){
        carController.fixSparkPlug(numeroBujia)
    }

    fun ajustarRpm(estadoActual: Int, estadoFinal: Int){
        val cantidad = Math.abs( estadoFinal - estadoActual) / 10
        if(estadoFinal > estadoActual){
            //TODO
        }
    }
}


interface CarController {
    fun getRpm(): Int
    fun setRpm(i : Int): Int
    fun fixSparkPlug(i: Int): Unit
    fun getSparkPlugLength(): Int
    fun status(): String

}
