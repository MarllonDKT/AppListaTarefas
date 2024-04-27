package com.example.applistatarefas.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    NOME_BANCO_DE_DADOS,
    null,
    VERSAO

) {

    companion object {
        const val NOME_BANCO_DE_DADOS = "ListaTarefas.db"
        const val VERSAO = 1
        const val NOME_TABELA_TAREFAS = "tarefas"
        const val ID_TAREFA = "id_tarefas"
        const val DESCRICAO = "descricao"
        const val DATA_CRIACAO = "data_criacao"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table if not EXISTS $NOME_TABELA_TAREFAS (" +
                "$ID_TAREFA integer NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "$DESCRICAO varchar(100)," +
                "$DATA_CRIACAO DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP" +
                ");"

        try {
            db?.execSQL(sql)
            Log.i("info_db", "Sucesso ao criar a tabela")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao criar a tabela")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}