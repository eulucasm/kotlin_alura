package com.lucao.orgs.ui.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucao.orgs.R
import com.lucao.orgs.model.Produto

class ListaProdutosAdapter(
   private val context: Context,
   private val produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {


   class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

      fun vincula(produto: Produto) {
         val nome = itemView.findViewById<TextView>(R.id.nome)
         nome.text = produto.nome

         val descricao = itemView.findViewById<TextView>(R.id.descricao)
         descricao.text = produto.descricao

         val valor = itemView.findViewById<TextView>(R.id.valor)
         valor.text = produto.valor.toPlainString()

      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

      val inflater = LayoutInflater.from(context)
      val view = inflater.inflate(R.layout.produto_item, parent, false)
      return ViewHolder(view)
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val produtos = produtos[position]
      holder.vincula(produtos)
   }

   override fun getItemCount(): Int = produtos.size


}
