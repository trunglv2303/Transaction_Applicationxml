package com.example.learnxml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnxml.Model.Transaction
import com.example.learnxml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transactions = listOf(
            Transaction(1, 150_000.0, "Chi", "16/11/2026"),
            Transaction(2, 500_000.0, "Thu", "17/11/2026"),
            Transaction(3, 75_000.0, "Chi", "18/11/2026")
        )
//        val edtName = findViewById<TextView>(R.id.edtName)
//        val editEmail=findViewById<TextView>(R.id.editEmail)
//        val editAge=findViewById<TextView>(R.id.editAge)
//        val btnShow = findViewById<Button>(R.id.btnShow)
//        val tvResult = findViewById<TextView>(R.id.tvResult)
//     btnShow.setOnClickListener {
//         val name = edtName.text.toString().trim()
//         val email=editEmail.text.toString().trim()
//         val age=editAge.text.toString().trim()
//if(name.isNotEmpty() && email.isNotEmpty() && age.isNotEmpty()){
//    tvResult.text = "Xin chào $name+  Email: $email  Tuổi: $age"
//}
        binding.recyclerTransactions.layoutManager = LinearLayoutManager(this)
        binding.recyclerTransactions.adapter = TransactionAdapter(transactions) { transaction ->
            val detailIntent = TransactionDetailActivity.createIntent(this, transaction)
            startActivity(detailIntent)
        }
    }

//binding =ActivityMainBinding.inflate( layoutInflater )
//        setContentView(binding.root)
//
//        binding.btnShow.setOnClickListener {
//            val name = binding.edtName.text.toString().trim()
//
//            if (name.isBlank()) {
//                binding.edtName.error = "Vui lòng nhập tên"
//                return@setOnClickListener
//            }
//            binding.tvResult.text="Xin chào $name"
//
//    }
}
