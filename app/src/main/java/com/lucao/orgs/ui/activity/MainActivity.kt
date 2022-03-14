package com.lucao.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucao.orgs.databinding.ActivityMainBinding
import com.lucao.orgs.model.Produto
import com.lucao.orgs.ui.recycler.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      binding = ActivityMainBinding.inflate(layoutInflater, null, false)

      setContentView(binding.root)
      binding.recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
         Produto(
            nome = "teste", descricao = "teste desc", valor = BigDecimal("20.99")
         ), Produto(
            nome = "teste2", descricao = "teste desc2", valor = BigDecimal("201.99")
         ), Produto(
            nome = "teste3", descricao = "teste desc3", valor = BigDecimal("202.99")
         ), Produto(
            nome = "teste4", descricao = "teste desc4", valor = BigDecimal("203.99")
         ), Produto(
            nome = "teste5", descricao = "teste desc5", valor = BigDecimal("204.99")
         )
      ))

      binding.floatingActionButton.setOnClickListener{
         val intent = Intent(this, FormularioProdutoActivity::class.java)
         startActivity(intent)
      }
   }


}