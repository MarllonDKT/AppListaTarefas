package com.example.applistatarefas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applistatarefas.database.DatabaseHelper
import com.example.applistatarefas.database.TarefaDAO
import com.example.applistatarefas.databinding.ActivityAdicionarTarefaBinding
import com.example.applistatarefas.databinding.ActivityMainBinding
import com.example.applistatarefas.model.Tarefa

class AdicionarTarefaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarTarefaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener {
           if(binding.editTarefa.text.isNotEmpty()){
               val descricao = binding.editTarefa.text.toString()
               val tarefa = Tarefa(
                   -1,
                   descricao,
                   "DEFAULT"
               )
               val tarefaDAO = TarefaDAO(this)
               if (tarefaDAO.salvar(tarefa)){
                   Toast.makeText(
                       this,
                       "Tarefa cadastrada com sucesso",
                       Toast.LENGTH_SHORT
                   ).show()
                   finish()
               }
           }else{
               Toast.makeText(
                   this,
                   "Preencha uma Tarefa",
                   Toast.LENGTH_SHORT
               ).show()
           }
        }
    }
}