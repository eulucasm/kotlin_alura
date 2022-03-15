package com.lucao.orgs.dao

import com.lucao.orgs.model.Produto

class ProdutosDao {

   fun adiciona(produto: Produto){
      produtos.add(produto)
   }

   fun buscaTodos() : List<Produto> {
      return produtos.toList()
   }

   companion object {
      private val produtos = mutableListOf<Produto>()
   }

}