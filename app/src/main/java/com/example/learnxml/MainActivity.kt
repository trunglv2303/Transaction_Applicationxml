package com.example.learnxml

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnxml.Model.Transaction
import com.example.learnxml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var transactionAdapter: TransactionAdapter
     val transactions = mutableListOf(
            Transaction(1, 150_000.0, "Chi", "16/11/2026"),
            Transaction(2, 500_000.0, "Thu", "17/11/2026"),
            Transaction(3, 75_000.0, "Chi", "18/11/2026")
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

   
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
        transactionAdapter = TransactionAdapter(transactions) { transaction ->
            val detailIntent = TransactionDetailActivity.createIntent(this, transaction)
            startActivity(detailIntent)
        }
        binding.recyclerTransactions.adapter = transactionAdapter
        binding.btnAddTransaction.setOnClickListener {
            val intent = Intent(this, AddTransaction::class.java)
            addTransactionLauncher.launch(intent)
        }
    }

    private val addTransactionLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data

        if (result.resultCode != RESULT_OK || data == null) {
            return@registerForActivityResult
        }

        val id = data.getIntExtra("id", 0)
        val amount = data.getDoubleExtra("amount", 0.0)
        val type = data.getStringExtra("type") ?: return@registerForActivityResult
        val date = data.getStringExtra("date") ?: return@registerForActivityResult

        val newTransaction = Transaction(id, amount, type, date)

        val newPosition = transactions.size
        transactions.add(newTransaction)
        transactionAdapter.notifyItemInserted(newPosition)
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
