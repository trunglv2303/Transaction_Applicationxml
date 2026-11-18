package com.example.learnxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learnxml.Model.Transaction
import com.example.learnxml.databinding.ActivityTransactionDetailBinding
import java.text.NumberFormat

class TransactionDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTransactionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val safeArea = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            view.setPadding(safeArea.left, safeArea.top, safeArea.right, safeArea.bottom)
            insets
        }

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val amount = intent.getDoubleExtra(EXTRA_AMOUNT, 0.0)
        val type = intent.getStringExtra(EXTRA_TYPE)
        val date = intent.getStringExtra(EXTRA_DATE)

        if (!intent.hasExtra(EXTRA_ID) || !intent.hasExtra(EXTRA_AMOUNT) || type == null || date == null) {
            finish()
            return
        }

        binding.tvId.text = getString(R.string.transaction_detail_id, id)
        val formattedAmount = NumberFormat.getNumberInstance().format(amount)
        binding.tvAmount.text = getString(R.string.transaction_detail_amount, formattedAmount)
        binding.tvType.text = getString(R.string.transaction_detail_type, type)
        binding.tvDate.text = getString(R.string.transaction_detail_date, date)
        binding.btnBack.setOnClickListener { finish() }
    }

    companion object {
        private const val EXTRA_ID = "transaction.id"
        private const val EXTRA_AMOUNT = "transaction.amount"
        private const val EXTRA_TYPE = "transaction.type"
        private const val EXTRA_DATE = "transaction.date"

        fun createIntent(context: Context, transaction: Transaction): Intent {
            val intent = Intent(context, TransactionDetailActivity::class.java)
            intent.putExtra(EXTRA_ID, transaction.id)
            intent.putExtra(EXTRA_AMOUNT, transaction.amount)
            intent.putExtra(EXTRA_TYPE, transaction.type)
            intent.putExtra(EXTRA_DATE, transaction.date)
            return intent
        }
    }
}
