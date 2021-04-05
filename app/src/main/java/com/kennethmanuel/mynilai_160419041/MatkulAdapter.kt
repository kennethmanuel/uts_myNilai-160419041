package com.kennethmanuel.mynilai_160419041

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_card.view.*

class MatkulAdapter(applicationContext: Context) :RecyclerView.Adapter<MatkulAdapter.MatkulViewHolder>() {
    class MatkulViewHolder(val view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatkulViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var v = inflater.inflate(R.layout.activity_card, parent, false)
        return  MatkulViewHolder(v)
    }

    override fun onBindViewHolder(holder: MatkulViewHolder, position: Int) {
        val matkul = Global.daftarMatkul[position]
        with(holder.view) {
            textViewNamaKodeMatkul.text = "${matkul.namaSingkat} (${matkul.kode})"

            if(matkul.NTS == -1) {
                checkBoxNTS.isChecked = false
            }
            if(matkul.NAS == -1) {
                checkBoxNAS.isChecked = false
            }
        }
    }

    override fun getItemCount() = Global.daftarMatkul.size
}