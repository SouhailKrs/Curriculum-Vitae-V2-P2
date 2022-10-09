package com.example.curriculum_vitae_v2_part2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.drawToBitmap
import androidx.navigation.fragment.findNavController
import com.example.curriculum_vitae_v2_part2.databinding.FragmentFirstBinding
import java.io.ByteArrayOutputStream
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.Navigation.findNavController
class SecondFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    val hobby = mutableListOf<String>()

    val language = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }



    private fun toast(message: String) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    }

}