# Diagramas de Sequência e de Estados

## 1. Diagramas de Sequência (Fluxo Principal)

Os diagramas abaixo mostram como as classes definidas na Semana 3 conversam entre si, passo a passo, para realizar as principais funções do sistema.

### 1.1. Caso de Uso: Solicitar Análise Inteligente (IA)
Este é o fluxo mais complexo do aplicativo, envolvendo o usuário, a tela do sistema, o processamento da análise e a aplicação opcional das sugestões.

---

### 1.2. Caso de Uso: Gerenciar Tarefas (Criar Nova Tarefa)
Mostra a colaboração entre o usuário, a categoria e a criação da tarefa na lista.

---

## 2. Diagrama de Estados (Classe `Tarefa`)

A classe **`Tarefa`** é o objeto do sistema que passa por mudanças claras de estado ao longo do tempo (desde o momento em que é criada até ser concluída, atrasada ou apagada).

### Explicação dos Estados
* **Pendente:** Estado inicial assim que a tarefa é criada pelo usuário.
* **Em Andamento:** O usuário iniciou a execução da atividade (ou ela foi priorizada na rotina).
* **Atrasada:** A data de vencimento passou e a tarefa ainda não foi concluída (estado identificado automaticamente pelo sistema e usado pela IA).
* **Concluída:** O usuário finalizou a atividade e marcou como feita.
* **Excluída:** Estado final caso o usuário decida apagar a tarefa da lista.