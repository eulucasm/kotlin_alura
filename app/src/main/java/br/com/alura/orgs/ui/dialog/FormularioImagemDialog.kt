package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

   fun mostra(urlPadrao: String?= null, imagemCarregada: (image: String) -> Unit) {
      val binding = FormularioImagemBinding
         .inflate(LayoutInflater.from(context))

      urlPadrao?.let {
         binding.formularioImagemImageview.tentaCarregarImagem(it)
         binding.formularioImagemUrl.setText(it)
      }

      binding.formularioImagemBotaoCarregar.setOnClickListener {
         val url = binding.formularioImagemUrl.text.toString()
         binding.formularioImagemImageview.tentaCarregarImagem(url)
      }

      AlertDialog.Builder(context)
         .setView(binding.root)
         .setPositiveButton("Confirmar") { _, _ ->
            val url = binding.formularioImagemUrl.text.toString()
            imagemCarregada(url)
         }
         .setNegativeButton("Cancelar") { _, _ ->

         }
         .show()
   }
}