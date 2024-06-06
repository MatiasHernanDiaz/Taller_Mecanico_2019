class Taller {
    val tecnicos : MutableList<Tecnico> = mutableListOf()
    val servicios: MutableList<Servicio> = mutableListOf()
    fun asignarTecnico(auto: Auto, tecnico: Tecnico){ tecnico.aceptarAuto(auto)}

    fun asignarTecnicoAutomaticamente(auto: Auto, tecnicoALaFuerza : Tecnico){
        val tecnico = tecnicos.find({it.aceptaAuto(auto)})
        if (tecnico != null) {
            asignarTecnico(auto, tecnico)
        }
        else{
            asignarTecnico(auto, tecnicoALaFuerza)
        }
    }
}

