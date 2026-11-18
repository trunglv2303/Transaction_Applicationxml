package com.example.learnxml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnxml.Model.Transaction
import com.example.learnxml.databinding.ItemTransactionBinding

class TransactionAdapter(
    private val transactions: List<Transaction>,
    private val onTransactionClick: (Transaction) -> Unit
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rowBinding = ItemTransactionBinding.inflate(inflater, parent, false)
        val holder = TransactionViewHolder(rowBinding)
        return holder
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.bind(transaction)
        holder.itemView.setOnClickListener {
            onTransactionClick(transaction)
        }
    }

    override fun getItemCount(): Int = transactions.size

    class TransactionViewHolder(
        private val rowBinding: ItemTransactionBinding
    ) : RecyclerView.ViewHolder(rowBinding.root) {

        fun bind(transaction: Transaction) {
            rowBinding.id.text = transaction.id.toString()
            rowBinding.tvAmount.text = transaction.amount.toString()
            rowBinding.tvType.text = transaction.type
            rowBinding.tvDate.text = transaction.date
        }
    }
}
