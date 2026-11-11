# Diagrama de Classes

## 1. Identificação das Classes e Encapsulamento

A partir das Histórias de Usuário, definimos as peças principais do sistema. Todos os **atributos são privados (`-`)** para proteger os dados, e os **métodos são públicos (`+`)** para permitir a interação segura entre as partes.

### Classes Principais

* **`Usuario` (Classe Base):** Guarda os dados de acesso da pessoa que usa o app.
  * *Atributos (`-`):* `id`, `nome`, `email`, `senha`
  * *Métodos (`+`):* `fazerLogin()`, `atualizarPerfil()`

* **`UsuarioComum` (Herança de `Usuario`):** Representa o usuário final do aplicativo, herdando os dados de login e gerenciando sua lista pessoal/profissional.
  * *Atributos (`-`):* `metaDiaria`
  * *Métodos (`+`):* `criarTarefa()`, `filtrarTarefas()`, `solicitarAnaliseIA()`

* **`Categoria`:** Permite separar as tarefas (ex: Pessoal, Trabalho, Estudos).
  * *Atributos (`-`):* `id`, `nome`, `cor`
  * *Métodos (`+`):* `editarCategoria()`

* **`Tarefa`:** É o coração do aplicativo, onde ficam as informações de cada atividade.
  * *Atributos (`-`):* `id`, `titulo`, `descricao`, `dataVencimento`, `prioridade`, `status`
  * *Métodos (`+`):* `editar()`, `concluir()`, `excluir()`, `atualizarPrioridade()`

* **`AnaliseIA`:** Representa o pedido de análise inteligente feito pelo usuário para organizar suas tarefas.
  * *Atributos (`-`):* `id`, `dataSolicitacao`, `statusAnalise`
  * *Métodos (`+`):* `processarTarefas()`, `gerarSugestoes()`

* **`SugestaoIA`:** Guarda cada recomendação criada pela IA para que o usuário aprove ou recuse antes de mudar qualquer tarefa.
  * *Atributos (`-`):* `id`, `novaPrioridade`, `novaOrdem`, `motivo`, `aceita`
  * *Métodos (`+`):* `aprovar()`, `recusar()`

---

## 2. Relacionamentos e Multiplicidade

* **Herança (`<|--`):** `UsuarioComum` herda de `Usuario` (aproveitando estrutura de login e perfil).
* **Associação (`1` para `0..*`):** Um `UsuarioComum` pode criar **zero ou muitas (`0..*`)** instâncias de `Tarefa` e `Categoria`.
* **Associação (`1` para `0..*`):** Uma `Categoria` pode estar ligada a **zero ou muitas (`0..*`)** instâncias de `Tarefa`, mas cada `Tarefa` pertence a **apenas uma (`1`)** `Categoria`.
* **Associação (`1` para `0..*`):** Um `UsuarioComum` pode solicitar **zero ou muitas (`0..*`)** `AnaliseIA`.
* **Composição (`1` para `1..*`):** Uma `AnaliseIA` gera **uma ou muitas (`1..*`)** `SugestaoIA` (se a análise for apagada, suas sugestões somem junto).
* **Associação (`1` para `0..*`):** Cada `SugestaoIA` aponta diretamente para **uma (`1`)** `Tarefa` específica.