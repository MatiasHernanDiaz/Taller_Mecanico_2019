//template method, command
abstract class Servicio(val auto: Auto, val costoBase: Double) {
    open fun ejecutarMejora(): Unit{}
    open fun calcularCosto(): Double = costoBase + this.adicionalServicio()

    abstract fun adicionalServicio(): Double

}

class Lavado(auto: Auto, costoBase: Double) : Servicio(auto, costoBase) {
    override fun ejecutarMejora() {
        TODO("Not yet implemented")
    }
    override fun adicionalServicio(): Double = 0.0
}

class Suspencion(auto: Auto, costoBase: Double, val suspencion: Double) : Servicio(auto, costoBase) {
    override fun ejecutarMejora() {
        
    }

    override fun adicionalServicio(): Double = costoBase * 2
}


class RepararCubiertas(auto: Auto, costoBase: Double, var listaRuedas: MutableList<Rueda>) : Servicio(auto, costoBase) {
    //ruedas = [DD, DI, TD, TI]
    override fun ejecutarMejora() {
        listaRuedas.forEach({it.dibujo = 8})
    }

    override fun adicionalServicio(): Double = listaRuedas.size * 200.00
}

class RotarCubiertas(auto: Auto, costoBase: Double) : Servicio(auto, costoBase) {
    override fun ejecutarMejora() {
        auto.ruedas.reverse()
    }

    override fun adicionalServicio(): Double = 200.00
}

class RegulacionMotor(
    auto: Auto,
    val desmonte: Boolean,
    val tiempo: Int,
    costoBase: Double):
    Servicio(auto, costoBase) {
    override fun ejecutarMejora() {
        TODO("Not yet implemented")
    }

    override fun adicionalServicio(): Double{
        if(desmonte){
            return 1000.00 + tiempo * 1500
        }
        else{
            return 0.0
        }
    }
}