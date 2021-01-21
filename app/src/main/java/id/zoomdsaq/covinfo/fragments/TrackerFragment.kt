package id.zoomdsaq.covinfo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.zoomdsaq.covinfo.R
import id.zoomdsaq.covinfo.activities.ProvinceActivity
import id.zoomdsaq.covinfo.api.RetrofitClient
import id.zoomdsaq.covinfo.models.IndonesiaResponse
import kotlinx.android.synthetic.main.fragment_tracker.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TrackerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showIndonesia()
        return inflater.inflate(R.layout.fragment_tracker, container, false)
    }

    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<IndonesiaResponse>>{
            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val terkonfirmasi = indonesia?.positif
                val sembuh = indonesia?.sembuh
                val meninggal = indonesia?.meninggal

                text_view_terkonfirmasi.text = terkonfirmasi
                text_view_sembuh.text = sembuh
                text_view_meninggal.text = meninggal

                btn_provinsi.setOnClickListener{
                    activity?.let{
                        val intent = Intent (it, ProvinceActivity::class.java)
                        it.startActivity(intent)
                    }
                }
            }
        })
    }
}