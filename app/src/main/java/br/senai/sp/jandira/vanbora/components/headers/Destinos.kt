package br.senai.sp.jandira.vanbora.components.headers


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import br.senai.sp.jandira.vanbora.R

sealed class Destinos(
    val ico: ImageVector,
    val title: String,
    val route: String
){
    object RotaPerfil: Destinos(Icons.Filled.PeopleAlt, "Ver perfil", "Vizualizar seu perfil")
    object RotaMeusContratos: Destinos(Icons.Filled.Newspaper, "Contratos", "Vizualizar meus contratos")
    object RotaLocalize: Destinos(Icons.Filled.Map, "Localize-se", "Localize-se")
    object RotaContate: Destinos(Icons.Filled.Phone, "Contate-nos", "Contate-nos")
    object RotaMotoristas: Destinos(Icons.Filled.AirportShuttle, "Motoristas", "Motoristas")
}