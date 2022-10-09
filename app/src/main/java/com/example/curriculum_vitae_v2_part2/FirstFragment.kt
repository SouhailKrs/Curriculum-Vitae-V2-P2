package com.example.curriculum_vitae_v2_part2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.curriculum_vitae_v2_part2.databinding.FragmentFirstBinding
import java.io.ByteArrayOutputStream

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    var profilePictureIsUploaded: Boolean = false
    private lateinit var gender: String
    private var SELECT_PICTURE = 200
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.plusButton.setOnClickListener {
            imageChooser()

        }
        binding.nextButton.setOnClickListener {
            //checkUserInput()
            println("eee")
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

            // findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }


    private fun checkUserInput() {


        val bitmap = binding.profilePic.drawToBitmap()
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val profile_pic = stream.toByteArray()

        val fullName = binding.fullNameField.editText?.text!!
        val age = binding.ageField.editText?.text!!
        val email = binding.emailField.editText?.text!!



        if (fullName.isEmpty()) {
            binding.fullNameField.error = "Must not be empty"
        }
        if (age.isEmpty()) {
            binding.ageField.error = "Must not be empty"
        }
        if (email.isEmpty()) {
            binding.emailField.error = "Must not be empty"
        }
        if (!binding.maleRadioButton.isChecked && !binding.femaleRadioButton.isChecked) {

            toast("Please select a gender")


        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailField.error = "Verify your email address"

        }
        if (!profilePictureIsUploaded) {
            toast("Please add a profile picture")

        } else {
            /*val navigation = FirstFragmentDirections.actionFirstFragmentToSecondFragment(

                fullName.toString(),
                age.toString(),
                email.toString(),
                checkSelectedGender(),
                profile_pic.toString()

            )
            println("aaaa")*/
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }


    }


    private fun imageChooser() {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        profilePictureIsUploaded = true

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                val selectedImageUri = data?.data
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    binding.profilePic.setImageURI(selectedImageUri)

                }
            }
        }
    }

    private fun checkSelectedGender(): String {

        if (binding.maleRadioButton.isChecked) {

            gender = binding.maleRadioButton.text.toString()

        }
        if (binding.femaleRadioButton.isChecked) {
            gender = binding.femaleRadioButton.text.toString()

        }

        return gender


    }

    private fun toast(message: String) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    }

}