class Taller {
    val tecnicos : MutableList<Tecnico> = mutableListOf()
    val servicios: MutableList<Servicio> = mutableListOf()
    fun asignarTecnico(auto: Auto, tecnico: Tecnico, servicio: Servicio){ tecnico.aceptarAuto(auto, servicio)}

    fun asignarTecnicoAutomaticamente(auto: Auto, servicio: Servicio, tecnicoALaFuerza : Tecnico){
        val tecnico = tecnicos.find({it.aceptaAuto(auto)})
        if (tecnico != null) {
            asignarTecnico(auto, tecnico, servicio)
        }
        else{
            asignarTecnico(auto, tecnicoALaFuerza, servicio)
        }
    }


}

