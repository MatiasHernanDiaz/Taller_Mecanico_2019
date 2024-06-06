class Tecnico(
    var tipoTecnico: TipoTecnico,
    var autoAsignado: Auto,
    var servicioAsignado: Servicio
) {
    fun aceptaAuto(auto: Auto): Boolean = tipoTecnico.aceptaAuto(auto)
    fun aceptarAuto(auto: Auto, servicio: Servicio) {
        autoAsignado = auto
        servicioAsignado = servicio
    }
}

//Se diseña la interfaz TipoTecnico como un Strategy polimorfico para solucionar
// la variabilidad de los tecnicos.
// para el AceptaPorAND y AceptaPorOR se aplica composite
interface TipoTecnico {
    fun aceptaAuto(auto: Auto): Boolean
}

class AceptaCualquiera() : TipoTecnico{
    override fun aceptaAuto(auto: Auto): Boolean = true
}

class AceptaPorMarca() : TipoTecnico{
    override fun aceptaAuto(auto: Auto): Boolean = auto.marca in mutableListOf("Ford", "Chevrolet")
}

class AceptaPorKm() : TipoTecnico{
    override fun aceptaAuto(auto: Auto): Boolean = auto.kilometraje < 100000
}

class  AceptaPorCliente(val nombreNoQuerido: String) : TipoTecnico {
    override fun aceptaAuto(auto: Auto): Boolean = auto.cliente.nombre != nombreNoQuerido
}

class AceptaPorPatente(): TipoTecnico {
    override fun aceptaAuto(auto: Auto): Boolean = auto.patente.get( auto.patente.length - 1 ).toInt() % 2 == 0
}

class AceptaPorOR(val tiposTecnicos: MutableList<TipoTecnico>) : TipoTecnico{
    override fun aceptaAuto(auto: Auto): Boolean = tiposTecnicos.any({it.aceptaAuto(auto)})

}

class AceptaPorAND(val tiposTecnicos: MutableList<TipoTecnico>) : TipoTecnico{
    override fun aceptaAuto(auto: Auto): Boolean = tiposTecnicos.all({it.aceptaAuto(auto)})

}