package com.moriss.utsandroid_pemandro3_10121077_fauzanfadhilmoricio

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

//10121077
//FauzanFadhilMoricio
//PemAndro3 (IF2)
//03/06/2024


class Data : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Hasil Data"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val NIK = intent.getStringExtra("NIK")
        val jenisTes = intent.getStringExtra("JENIS_TES")
        val tanggalTerkonfirmasi = intent.getStringExtra("TANGGAL_TERKONFIRMASI")
        val nama = intent.getStringExtra("NAMA")
        val tanggalLahir = intent.getStringExtra("TANGGAL_LAHIR")
        val jenisKelamin = intent.getStringExtra("JENIS_KELAMIN")
        val hubungan = intent.getStringExtra("HUBUNGAN")

        findViewById<TextView>(R.id.textViewNIK).text = NIK
        findViewById<TextView>(R.id.textViewJenisTes).text = jenisTes
        findViewById<TextView>(R.id.textViewTanggalTerkonfirmasi).text = tanggalTerkonfirmasi
        findViewById<TextView>(R.id.textViewNama).text = nama
        findViewById<TextView>(R.id.textViewTanggalLahir).text = tanggalLahir
        findViewById<TextView>(R.id.textViewJenisKelamin).text = jenisKelamin
        findViewById<TextView>(R.id.textViewHubungan).text = hubungan

        findViewById<Button>(R.id.btn_hasil).setOnClickListener {

            val dialogView = layoutInflater.inflate(R.layout.simpandata, null)

            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false) // Make it non-cancelable if desired
                .create()

            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation

            dialogView.findViewById<Button>(R.id.buttonOk).setOnClickListener {
                dialog.dismiss()
            }


            dialog.show()

            val window = dialog.window
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            window?.setGravity(Gravity.BOTTOM)
            window?.setBackgroundDrawableResource(android.R.color.transparent)
        }

        val btnUbah: Button = findViewById(R.id.btn_ubah)

        btnUbah.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
