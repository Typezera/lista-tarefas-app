package com.teste.lista_tarefas_app.controller;

import com.teste.lista_tarefas_app.models.Status;
import com.teste.lista_tarefas_app.models.Tarefa;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tarefas")
public class TarefaController
{
    @PostMapping("/ctarefas/{titulo}/{descricao}/{status}")
    public Tarefa criarTarefa(@PathVariable String titulo,
                              @PathVariable String descricao,
                              @PathVariable Status status)
    {
        for(Tarefa i : Tarefa.listaTarefa)
        {
            if(i.getTitulo().equals(titulo) && i.getDescricao().equals(titulo) && i.getStatus() == status)
            {
                return null;
            }
        }

        //String titulo, String descricao, Status status
        return new Tarefa(titulo, descricao, status);
    }

    @GetMapping("/consultar")
    public List<Tarefa> consultarTarefa()
    {
        return Tarefa.listaTarefa;
    }

    //está com bug de duplicação
    //pois a lista está sendo armazenada na memoria!
    @PutMapping("/atualizar/{id}")
    public Tarefa atualizarTarefa(@PathVariable int id,
                                  @RequestBody Tarefa tarefaAtualizada)
    {
        for(Tarefa i : Tarefa.listaTarefa)
        {
            if(i.getId() == id)
            {
                i.setTitulo(tarefaAtualizada.getTitulo());
                i.setDescricao(tarefaAtualizada.getDescricao());
                i.setStatus(tarefaAtualizada.getStatus());
                return i;
            }
        }
        return null;
    }

    @DeleteMapping("/deletar/{id}")
    public Tarefa deletarTarefa(@PathVariable int id)
    {
        Tarefa deleteTarefa = null;

        for(Tarefa i : Tarefa.listaTarefa)
        {
            if(i.getId() == id)
            {
                deleteTarefa = i;
                break;
            }
        }
        if(deleteTarefa != null)
        {
            Tarefa.listaTarefa.remove(deleteTarefa);
        }
        return deleteTarefa;
    }
}
