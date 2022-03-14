package com.lucao.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lucao.orgs.databinding.ActivityFormularioProdutoBinding
import com.lucao.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

   private lateinit var binding: ActivityFormularioProdutoBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)

      binding.botaoSalvar.setOnClickListener {
         val nome = binding.nomeFormulario.text.toString()
         val descricao = binding.descricaoFormulario.text.toString()
         val valor = binding.valorFormulario.text.toString()
         val valorVerificacao = if (valor.isBlank()) {
            BigDecimal.ZERO
         } else {
            BigDecimal(valor)
         }

         val produtoNovo = Produto(
            nome = nome,
            descricao = descricao,
            valor = valorVerificacao,
         )
         Log.i("FormularioProduto", "onCreate: $produtoNovo")

      }
   }

}