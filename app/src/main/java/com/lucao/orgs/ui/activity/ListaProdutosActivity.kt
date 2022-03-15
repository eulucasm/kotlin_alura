package com.lucao.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucao.orgs.dao.ProdutosDao
import com.lucao.orgs.databinding.ActivityListaProdutosBinding
import com.lucao.orgs.ui.recycler.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

   private val dao = ProdutosDao()
   private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())
   private val binding by lazy {
      ActivityListaProdutosBinding.inflate(layoutInflater)
   }

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)
      configuraRecyclerView()
      configuraFab()
   }

   override fun onResume() {
      super.onResume()
      adapter.atualiza(dao.buscaTodos())
   }

   private fun configuraFab() {
      val fab = binding.floatingActionButton
      fab.setOnClickListener {
         vaiParaFormularioProduto()
      }
   }

   private fun vaiParaFormularioProduto() {
      val intent = Intent(this, FormularioProdutoActivity::class.java)
      startActivity(intent)
   }

   private fun configuraRecyclerView() {
      val recyclerView = binding.recyclerView
      recyclerView.adapter = adapter
   }

}