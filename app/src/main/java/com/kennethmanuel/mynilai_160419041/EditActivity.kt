package com.kennethmanuel.mynilai_160419041

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.utils.widget.MockView
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val pos = intent.getIntExtra(Global.INDEXEDITED, 0)
        var kodeMatkul = Global.daftarMatkul[pos].kode
        var namaMatkul = Global.daftarMatkul[pos].nama
        var namaSingkat = Global.daftarMatkul[pos].namaSingkat
        var nts = Global.daftarMatkul[pos].NTS
        var nas = Global.daftarMatkul[pos].NAS

        editTextKodeMatkul5.setText(kodeMatkul)
        editTextNamaMatkul5.setText(namaMatkul)
        editTextNamaSingkat5.setText(namaSingkat)
        if (nts != -1) editTextNTS5.setText(nts.toString())
        if (nas != -1) editTextNAS5.setText(nas.toString())

        buttonSimpan.setOnClickListener {
            kodeMatkul = editTextKodeMatkul5.text.toString()
            namaMatkul = editTextNamaMatkul5.text.toString()
            namaSingkat = editTextNamaSingkat5.text.toString()
            var NTS = -1
            var NAS = -1

            if (editTextNTS5.text.isNotEmpty()) {
                NTS = editTextNTS5.text.toString().toInt()
            }
            if (editTextNAS5.text.isNotEmpty()) {
                NAS = editTextNAS5.text.toString().toInt()
            }

            val builder = AlertDialog.Builder(this)
            if(editTextNamaMatkul5.text.isEmpty() || editTextKodeMatkul5.text.isEmpty() || editTextNamaSingkat5.text.isEmpty()) {
                with(builder) {
                    setTitle("Kesalahan")
                    setMessage("Kode, nama, dan nama singkat mata kuliah harus diisi.")
                    setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                    show()
                }
            }

            if (kodeMatkul.length != 8) {
                with(builder) {
                    setTitle("Kesalahan")
                    setMessage("Kode mata kuliah harus 8 karakter!")
                    setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                    show()
                }
            } else if (namaSingkat.contains(" ")) {
                with(builder) {
                    setTitle("Kesalahan")
                    setMessage("Nama singkat tidak boleh mengandung spasi")
                    setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                    show()
                }
            } else if (editTextNTS5.text.isNotEmpty() || editTextNAS5.text.isNotEmpty()) {
                if(editTextNTS5.text.isNotEmpty() && editTextNAS5.text.isNotEmpty()) {
                    if (NTS < 0 || NTS > 100 || NAS < 0 || NAS > 100) {
                        with(builder) {
                            setTitle("Kesalahan")
                            setMessage("Nilai NTS dan NAS hanya boleh diantara 0 dan 100")
                            setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                            show()
                        }
                    } else {
                        Global.daftarMatkul.set(pos, Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS))
                        with(builder) {
                            setMessage("Mata kuliah berhasil ditambahkan")
                            setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                                finish()
                            }
                            show()
                        }
                    }
                } else if (editTextNTS5.text.isNotEmpty()) {
                    if (NTS < 0 || NTS > 100) {
                        with(builder) {
                            setTitle("Kesalahan")
                            setMessage("Nilai NTS dan NAS hanya boleh diantara 0 dan 100")
                            setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                            show()
                        }
                    } else {
                        Global.daftarMatkul.set(pos, Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS))
                        with(builder) {
                            setMessage("Mata kuliah berhasil ditambahkan")
                            setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                                finish()
                            }
                            show()
                        }
                    }
                } else if (editTextNAS5.text.isNotEmpty()) {
                    if (NAS < 0 || NAS > 100) {
                        with(builder) {
                            setTitle("Kesalahan")
                            setMessage("Nilai NTS dan NAS hanya boleh diantara 0 dan 100")
                            setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                            show()
                        }
                    } else {
                        Global.daftarMatkul[pos] = Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS)
                        with(builder) {
                            setMessage("Mata kuliah berhasil ditambahkan")
                            setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                                finish()
                            }
                            show()
                        }
                    }
                } else {
                    Global.daftarMatkul[pos] = Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS)
                    with(builder) {
                        setMessage("Mata kuliah berhasil ditambahkan")
                        setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                            finish()
                        }
                        show()
                    }
                }
            } else {
                Global.daftarMatkul[pos] = Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS)
                with(builder) {
                    setMessage("Mata kuliah berhasil ditambahkan")
                    setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                        finish()
                    }
                    show()
                }
            }

        }
    }
}