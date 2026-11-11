# Descrição Textual dos 2 Casos de Uso Mais Importantes

### Caso de Uso 1: Gerenciar Tarefas
* **ID:** UC-02
* **Nome:** Gerenciar Tarefas
* **Atores:** Usuário
* **Descrição:** Permite ao usuário criar, editar, marcar como concluída e excluir tarefas do dia a dia, definindo data, prioridade, status e categoria.
* **Pré-condições:** O usuário deve estar logado no sistema.
* **Pós-condições:** A tarefa é criada, alterada, concluída ou excluída com sucesso no aplicativo.

**Fluxo Principal (Criar Nova Tarefa):**
1. O usuário toca no botão de adicionar uma nova tarefa.
2. O sistema abre a tela de cadastro.
3. O usuário preenche o nome da tarefa e escolhe a **Data**, **Prioridade**, **Status** e **Categoria** (ex: Pessoal ou Trabalho).
4. O usuário confirma o salvamento.
5. O sistema salva a tarefa e a mostra na tela inicial.

**Fluxos Alternativos:**
* **FA-01 – Editar ou Concluir Tarefa:** Na lista de tarefas, o usuário clica em uma tarefa existente para alterar seus dados ou marca a caixa de conclusão para mudar o status para "Concluída". O sistema atualiza o item na hora.
* **FA-02 – Excluir Tarefa:** O usuário seleciona a opção de apagar uma tarefa. O sistema pede confirmação e remove o item da lista.

**Fluxos de Exceção:**
* **FE-01 – Campos Obrigatórios Vazios:** Se o usuário tentar salvar a tarefa sem escrever um nome, o sistema exibe um aviso na tela e pede para preencher o campo antes de salvar.

---

### Caso de Uso 2: Solicitar Análise Inteligente
* **ID:** UC-04
* **Nome:** Solicitar Análise Inteligente
* **Atores:** Usuário e Serviço de IA
* **Descrição:** Permite que o usuário peça uma análise de suas tarefas para a IA, que avalia prazos e prioridades para sugerir uma melhor ordem de execução e evitar esquecimentos.
* **Pré-condições:** 
  1. O usuário deve estar logado no sistema.
  2. O usuário deve ter pelo menos **duas tarefas** cadastradas.
* **Pós-condições:** O sistema mostra as sugestões geradas pela IA e, se o usuário aceitar, aplica as mudanças nas tarefas escolhidas.

**Fluxo Principal (Caminho Feliz):**
1. O usuário solicita uma análise inteligente de suas tarefas.
2. A IA analisa as atividades e identifica melhorias na organização e prioridades.
3. O sistema mostra as sugestões geradas na tela para o usuário.
4. O usuário olha as recomendações e decide quais deseja aplicar.
5. O sistema aplica apenas as sugestões selecionadas pelo usuário.
6. O sistema informa que a análise e as alterações foram concluídas.

**Fluxos Alternativos:**
* **FA-01 – Analisar apenas algumas tarefas:** Antes de pedir a análise, o usuário seleciona apenas as tarefas que deseja avaliar. A IA analisa e dá sugestões somente para os itens escolhidos.
* **FA-02 – Tarefas atrasadas:** Durante a análise, o sistema identifica tarefas fora do prazo. A IA considera esse atraso e sugere novas prioridades ou datas para colocá-las em dia.

**Fluxos de Exceção:**
* **FE-01 – Poucas tarefas cadastradas:** Se o usuário tiver menos de duas tarefas na lista, o sistema avisa que não há tarefas suficientes para análise, orienta a cadastrar pelo menos duas e encerra a ação.
* **FE-02 – Sem acesso à internet ou falha na IA:** Se não houver conexão com a internet no momento do pedido, o sistema avisa que não é possível fazer a análise agora, mantém todas as tarefas intactas e encerra a ação.