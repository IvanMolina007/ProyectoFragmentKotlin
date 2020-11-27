package com.example.proyectofragmentkotlin

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_camara_main.*


class CamaraMainFragment : Fragment() {

    private var REQUEST_IMAGE_CAPTURE = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camara_main, container, false)
    }


    private fun hacerFoto() {
        val permissionCheck =
            context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) }
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            val callCamaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCamaraIntent.resolveActivity(requireActivity().packageManager) != null) {
                this.startActivityForResult(callCamaraIntent, REQUEST_IMAGE_CAPTURE)
            }
        } else {
            ActivityCompat.requestPermissions(
                (context as Activity),
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_IMAGE_CAPTURE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            val imageBitmap = data.extras?.get("data") as Bitmap
            imageView11.setImageBitmap(imageBitmap)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonHacerFoto.setOnClickListener {
            hacerFoto()
        }
    }

}