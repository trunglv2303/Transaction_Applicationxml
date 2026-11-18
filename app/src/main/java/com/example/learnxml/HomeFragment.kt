
package com.example.learnxml

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.learnxml.databinding.FragmentHomeBinding
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private val binding: FragmentHomeBinding
        get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        binding.btnChange.setOnClickListener {
            binding.tvTitle.text = "Đã thay đổi!"
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
