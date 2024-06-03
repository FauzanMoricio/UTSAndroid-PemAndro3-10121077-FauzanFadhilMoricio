package com.moriss.utsandroid_pemandro3_10121077_fauzanfadhilmoricio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

//<!--    10121077-->
//<!--    FauzanFadhilMoricio-->
//<!--    PemAndro3 (IF2)-->
//<!--    03/06/2024-->


class MainActivity : AppCompatActivity() {

    private lateinit var edtNIK: EditText
    private lateinit var edtNama: EditText
    private lateinit var edtTanggalLahir: EditText
    private lateinit var edtTanggalTerkonfirmasi: EditText
    private lateinit var radioGroupJenisTes: RadioGroup
    private lateinit var radioGroupJenisKelamin: RadioGroup
    private lateinit var radioGroupHubungan: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNIK = findViewById(R.id.edit_NIK)
        edtNama = findViewById(R.id.edt_nama)
        edtTanggalLahir = findViewById(R.id.edt_tanggal_lahir)
        edtTanggalTerkonfirmasi = findViewById(R.id.editTextDate)

        radioGroupJenisTes = findViewById(R.id.radioGroup2)
        radioGroupJenisKelamin = findViewById(R.id.grup_kelamin)
        radioGroupHubungan = findViewById(R.id.grup_hubungan)

        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            val NIK = edtNIK.text.toString()
            val nama = edtNama.text.toString()
            val tanggalLahir = edtTanggalLahir.text.toString()
            val tanggalTerkonfirmasi = edtTanggalTerkonfirmasi.text.toString()

            // Get selected RadioButton data
            val jenisTes = findViewById<RadioButton>(radioGroupJenisTes.checkedRadioButtonId)?.text.toString()
            val jenisKelamin = findViewById<RadioButton>(radioGroupJenisKelamin.checkedRadioButtonId)?.text.toString()
            val hubungan = findViewById<RadioButton>(radioGroupHubungan.checkedRadioButtonId)?.text.toString()

            // Create an Intent to start Data activity
            val intent = Intent(this@MainActivity, Data::class.java).apply {
                putExtra("NIK", NIK)
                putExtra("JENIS_TES", jenisTes)
                putExtra("TANGGAL_TERKONFIRMASI", tanggalTerkonfirmasi)
                putExtra("NAMA", nama)
                putExtra("TANGGAL_LAHIR", tanggalLahir)
                putExtra("JENIS_KELAMIN", jenisKelamin)
                putExtra("HUBUNGAN", hubungan)
            }

            // Start Data activity
            startActivity(intent)
        }
    }
}
