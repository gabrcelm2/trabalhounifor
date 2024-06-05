package com.example.trabalho32

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.io.ByteArrayOutputStream


class addObra : Fragment() {

    private var nomeObra: EditText? = null
    private lateinit var imageView: ImageView
    private var imageString: String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_add_obra, container, false)
        nomeObra = view.findViewById<EditText>(R.id.editTextNomeObra)
        imageView = view.findViewById<ImageView>(R.id.imageViewObra)

        imageView.setOnClickListener {
            openGallery()
        }

        view.findViewById<Button>(R.id.buttonSalvar).setOnClickListener {
            Log.d("banco","onclick escrever banco")
            Firebase.firestore.collection("Obras").add(mapOf(
                "nome" to nomeObra?.text.toString(),
                "imagem" to imageString

            ))

        }

        return view
    }
    fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 ) {
            data?.data?.let { uri ->
                // Aqui você pode manipular a URI da imagem selecionada
                //val imageView: ImageView = findViewById(R.id.imageView)


                imageView.setImageURI(uri)

                // Converter o Bitmap do ImageView em um array de bytes
                val byteArray = getByteArrayFromImageView(imageView)

                // Converter o array de bytes em uma string base64
                imageString = Base64.encodeToString(byteArray, Base64.DEFAULT)
            }
        }
    }
    private fun getByteArrayFromImageView(imageView: ImageView): ByteArray? {
        val drawable = imageView.drawable as BitmapDrawable
        val bitmap = drawable.bitmap

        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        return byteArrayOutputStream.toByteArray()
    }
}