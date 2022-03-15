package com.lucao.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucao.orgs.dao.ProdutosDao
import com.lucao.orgs.databinding.ActivityFormularioProdutoBinding
import com.lucao.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

   private val binding by lazy {
      ActivityFormularioProdutoBinding.inflate(layoutInflater)
   }

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)
      configuraBotaoSalvar()
   }

   private fun configuraBotaoSalvar() {
      val botaoSalvar = binding.botaoSalvar
      val dao = ProdutosDao()
      botaoSalvar.setOnClickListener {
         val produtoNovo = criaProduto()
         dao.adiciona(produtoNovo)
         finish()
      }
   }

   private fun criaProduto(): Produto {
      val campoNome = binding.nomeFormulario
      val nome = campoNome.text.toString()
      val campoDescricao = binding.descricaoFormulario
      val descricao = campoDescricao.text.toString()
      val campoValor = binding.valorFormulario
      val valorEmTexto = campoValor.text.toString()
      val valor = if (valorEmTexto.isBlank()) {
         BigDecimal.ZERO
      } else {
         BigDecimal(valorEmTexto)
      }

      return Produto(
         nome = nome,
         descricao = descricao,
         valor = valor
      )
   }

}