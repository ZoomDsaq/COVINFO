package id.zoomdsaq.covinfo.api

import id.zoomdsaq.covinfo.models.IndonesiaResponse
import id.zoomdsaq.covinfo.models.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}