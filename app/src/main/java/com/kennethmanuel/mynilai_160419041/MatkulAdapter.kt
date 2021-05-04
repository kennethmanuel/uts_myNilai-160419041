package com.kennethmanuel.mynilai_160419041

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

            if(matkul.NTS != -1 && matkul.NAS != -1) {
                val nisbi = matkul.NTS * 0.4 + matkul.NAS * 0.6
                when(nisbi) {
                    in 81.0..100.0 -> textViewNisbi.text = "A"
                    in 73.0..81.0 -> textViewNisbi.text = "AB"
                    in 66.0..73.0 -> textViewNisbi.text = "B"
                    in 60.0..66.0 -> textViewNisbi.text = "BC"
                    in 55.0..60.0 -> textViewNisbi.text = "C"
                    in 40.0..55.0 -> textViewNisbi.text = "D"
                    in 0.0..40.0 -> textViewNisbi.text = "E"
                }
            }

            buttonEdit.setOnClickListener {
                val intent = Intent(context, EditActivity::class.java)
                intent.putExtra(Global.INDEXEDITED, position)
                context.startActivity(intent)
            }

            imageButtonDelete.setOnClickListener{
                val builder = AlertDialog.Builder(context)
                builder.setMessage("Delete mata kuliah " + Global.daftarMatkul[position].nama + "?")
                builder.setPositiveButton("DELETE", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                    Global.daftarMatkul.removeAt(position)
                    this@MatkulAdapter.notifyDataSetChanged()
                    Toast.makeText(context, "Mata kuliah ${matkul.nama} telah dihapus.", Toast.LENGTH_SHORT).show()
                })
                builder.setNegativeButton("CANCEL", null)
                builder.create().show()
            }

        }
    }

    override fun getItemCount() = Global.daftarMatkul.size
}