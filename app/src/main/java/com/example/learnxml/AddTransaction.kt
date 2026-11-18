package com.example.learnxml

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnxml.databinding.ActivityMainBinding
import com.example.learnxml.databinding.AddTransactionBinding

class AddTransaction : AppCompatActivity(){
    private lateinit var binding: AddTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            val id = binding.edtId.text.toString().toIntOrNull()
            val amount = binding.edtAmount.text.toString().toDoubleOrNull()
            val type = binding.edtType.text.toString().trim()
            val date = binding.edtDate.text.toString().trim()
    if (id == null) {
        binding.edtId.error = "Nhập mã giao dịch hợp lệ"
        return@setOnClickListener
    }

    if (amount == null) {
        binding.edtAmount.error = "Nhập số tiền hợp lệ"
        return@setOnClickListener
    }

    if (type.isBlank()) {
        binding.edtType.error = "Nhập loại giao dịch"
        return@setOnClickListener
    }

    if (date.isBlank()) {
        binding.edtDate.error = "Nhập ngày giao dịch"
        return@setOnClickListener
    }

    val result = Intent()
    result.putExtra("id", id)
    result.putExtra("amount", amount)
    result.putExtra("type", type)
    result.putExtra("date", date)

    setResult(RESULT_OK, result)
    finish()



        }
    }
}