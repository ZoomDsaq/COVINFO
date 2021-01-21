package id.zoomdsaq.covinfo.models

import com.google.gson.annotations.SerializedName

data class  Province(
    @SerializedName("Kode_Provi")
    val kode: Int,
    @SerializedName("Provinsi")
    val provinsi: String,
    @SerializedName("Kasus_Posi")
    val positif: Int,
    @SerializedName("Kasus_Semb")
    val sembuh: Int,
    @SerializedName("Kasus_Meni")
    val meninggal: Int
)