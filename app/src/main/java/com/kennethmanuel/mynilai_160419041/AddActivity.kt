package com.kennethmanuel.mynilai_160419041

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        buttonTambahMatkul.setOnClickListener {
            var kodeMatkul = editTextKodeMatkul.text.toString()
            var namaMatkul = editTextNamaMatkul.text.toString()
            var namaSingkat = editTextNamaSingkat.text.toString()
            var NTS = -1
            var NAS = -1

            if (editTextNTS.text.isNotEmpty()) {
                NTS = editTextNTS.text.toString().toInt()
            }
            if (editTextNAS.text.isNotEmpty()) {
                NAS = editTextNAS.text.toString().toInt()
            }

            val builder = AlertDialog.Builder(this)
            if(editTextNamaMatkul.text.isEmpty() || editTextKodeMatkul.text.isEmpty() || editTextNamaSingkat.text.isEmpty()) {
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
            } else if (editTextNTS.text.isNotEmpty() || editTextNAS.text.isNotEmpty()) {
                if(editTextNTS.text.isNotEmpty() && editTextNAS.text.isNotEmpty()) {
                    if (NTS < 0 || NTS > 100 || NAS < 0 || NAS > 100) {
                        with(builder) {
                            setTitle("Kesalahan")
                            setMessage("Nilai NTS dan NAS hanya boleh diantara 0 dan 100")
                            setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                            show()
                        }
                    } else {
                        Global.daftarMatkul.add(Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS))
                        with(builder) {
                            setMessage("Mata kuliah berhasil ditambahkan")
                            setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                                finish()
                            }
                            show()
                        }
                    }
                } else if (editTextNTS.text.isNotEmpty()) {
                    if (NTS < 0 || NTS > 100) {
                        with(builder) {
                            setTitle("Kesalahan")
                            setMessage("Nilai NTS dan NAS hanya boleh diantara 0 dan 100")
                            setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                            show()
                        }
                    } else {
                        Global.daftarMatkul.add(Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS))
                        with(builder) {
                            setMessage("Mata kuliah berhasil ditambahkan")
                            setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                                finish()
                            }
                            show()
                        }
                    }
                } else if (editTextNAS.text.isNotEmpty()) {
                    if (NAS < 0 || NAS > 100) {
                        with(builder) {
                            setTitle("Kesalahan")
                            setMessage("Nilai NTS dan NAS hanya boleh diantara 0 dan 100")
                            setPositiveButton("Ok", { dialog: DialogInterface?, which: Int -> })
                            show()
                        }
                    } else {
                        Global.daftarMatkul.add(Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS))
                        with(builder) {
                            setMessage("Mata kuliah berhasil ditambahkan")
                            setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                                finish()
                            }
                            show()
                        }
                    }
                } else {
                    Global.daftarMatkul.add(Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS))
                    with(builder) {
                        setMessage("Mata kuliah berhasil ditambahkan")
                        setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                            finish()
                        }
                        show()
                    }
                }
            } else {
                Global.daftarMatkul.add(Matkul(kodeMatkul, namaMatkul, namaSingkat, NTS, NAS))
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
