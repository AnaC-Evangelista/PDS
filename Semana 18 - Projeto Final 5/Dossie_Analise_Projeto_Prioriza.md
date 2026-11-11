# Dossiê de Análise do Projeto: Prioriza

**Integrantes:**
* Ana Carolina Diniz Evangelista
* Lourena Beatriz Santos de Sousa
* Luiz Henrique Camilo
* Nycolle Beatriz Silva Mariano

---

## Parte 1: Proposta do Projeto (Semana 1)

### 1.1. O Problema
No dia a dia, muita gente tenta dar conta de tarefas pessoais e do trabalho ao mesmo tempo. Sem uma organização simples, é fácil se perder no meio de tanta coisa. Isso causa:
* **Falta de produtividade:** Começar várias tarefas e não terminar nenhuma, esquecer o que precisa ser feito, cometer erros e ter que refazer o trabalho.
* **Cansaço mental:** O excesso de coisas acumuladas gera estresse, ansiedade, frustração e exaustão.

### 1.2. Público-Alvo
O **Prioriza** é feito para **pessoas atarefadas que querem organizar a vida pessoal**, mas que também precisam cuidar das demandas do trabalho em um só lugar, de um jeito fácil e sem complicação.

### 1.3. A Solução
Um aplicativo simples para organizar as tarefas do dia a dia, que usa **Inteligência Artificial** para ajudar o usuário a decidir o que fazer primeiro:
* **Tudo no lugar:** O usuário cadastra suas tarefas e organiza tudo por **Data, Prioridade, Status e Categoria** (separando facilmente o que é pessoal e o que é trabalho).
* **Ajuda da Inteligência Artificial:** Com um clique, a IA analisa as tarefas cadastradas (todas ou só as que o usuário escolher). Ela identifica o que está atrasado ou acumulado e sugere uma ordem melhor para fazer tudo.
* **Você no controle:** A IA apenas dá sugestões. As tarefas só mudam de lugar ou de prioridade se o usuário aceitar, garantindo total liberdade na rotina.


---

## Parte 2: A Visão do Usuário — Requisitos e Casos de Uso (Semana 2)

### 2.1. Histórias de Usuário
* **US-01:** Como um `usuário`, eu quero `fazer login no aplicativo` para que `minhas tarefas fiquem salvas com segurança e acessíveis só para mim`.
* **US-02:** Como um `usuário`, eu quero `cadastrar tarefas com data, prioridade, status e categoria (pessoal ou trabalho)` para que `eu consiga organizar todos os meus compromissos em um só lugar`.
* **US-03:** Como um `usuário`, eu quero `editar, concluir ou excluir minhas tarefas` para que `a minha lista esteja sempre atualizada conforme eu realizo minhas atividades`.
* **US-04:** Como um `usuário`, eu quero `filtrar minhas tarefas por data, prioridade, status ou categoria` para que `eu encontre rapidamente o que preciso fazer no momento`.
* **US-05:** Como um `usuário atarefado`, eu quero `pedir para a Inteligência Artificial analisar minhas tarefas` para que `eu receba sugestões de prioridades e uma melhor ordem de execução`.
* **US-06:** Como um `usuário`, eu quero `escolher quais sugestões da IA desejo aplicar` para que `eu tenha o controle total sobre a minha própria rotina`.

### 2.2. Diagrama de Casos de Uso (UML)

### 2.3. Descrição Textual dos 2 Casos de Uso Mais Importantes

#### Caso de Uso 1: Gerenciar Tarefas (UC-02)
* **Atores:** Usuário
* **Descrição:** Permite ao usuário criar, editar, marcar como concluída e excluir tarefas do dia a dia, definindo data, prioridade, status e categoria.
* **Pré-condições:** O usuário deve estar logado no sistema.
* **Pós-condições:** A tarefa é criada, alterada, concluída ou excluída com sucesso no aplicativo.
* **Fluxo Principal (Criar Nova Tarefa):**
  1. O usuário toca no botão de adicionar uma nova tarefa.
  2. O sistema abre a tela de cadastro.
  3. O usuário preenche o nome da tarefa e escolhe a **Data**, **Prioridade**, **Status** e **Categoria** (ex: Pessoal ou Trabalho).
  4. O usuário confirma o salvamento.
  5. O sistema salva a tarefa e a mostra na tela inicial.
* **Fluxos Alternativos:**
  * **FA-01 – Editar ou Concluir Tarefa:** O usuário clica em uma tarefa existente para alterar seus dados ou marca a caixa de conclusão para mudar o status para "Concluída".
  * **FA-02 – Excluir Tarefa:** O usuário seleciona a opção de apagar uma tarefa, confirma a ação e o sistema remove o item.
* **Fluxos de Exceção:**
  * **FE-01 – Campos Obrigatórios Vazios:** Se o usuário tentar salvar sem escrever um nome, o sistema exibe um aviso na tela e pede para preencher o campo antes de salvar.

#### Caso de Uso 2: Solicitar Análise Inteligente (UC-04)
* **Atores:** Usuário e Serviço de IA
* **Descrição:** Permite que o usuário peça uma análise de suas tarefas para a IA, que avalia prazos e prioridades para sugerir uma melhor ordem de execução e evitar esquecimentos.
* **Pré-condições:** O usuário deve estar logado e ter pelo menos **duas tarefas** cadastradas.
* **Pós-condições:** O sistema mostra as sugestões geradas pela IA e, se o usuário aceitar, aplica as mudanças nas tarefas escolhidas.
* **Fluxo Principal (Caminho Feliz):**
  1. O usuário solicita uma análise inteligente de suas tarefas.
  2. A IA analisa as atividades e identifica melhorias na organização e prioridades.
  3. O sistema mostra as sugestões geradas na tela para o usuário.
  4. O usuário olha as recomendações e decide quais deseja aplicar.
  5. O sistema aplica apenas as sugestões selecionadas pelo usuário.
  6. O sistema informa que a análise e as alterações foram concluídas.
* **Fluxos Alternativos:**
  * **FA-01 – Analisar apenas algumas tarefas:** O usuário seleciona apenas as tarefas que deseja avaliar antes de pedir a análise.
  * **FA-02 – Tarefas atrasadas:** O sistema identifica tarefas fora do prazo e a IA sugere novas prioridades ou datas para colocá-las em dia.
* **Fluxos de Exceção:**
  * **FE-01 – Poucas tarefas cadastradas:** Se o usuário tiver menos de duas tarefas, o sistema avisa que não há itens suficientes e encerra a ação.
  * **FE-02 – Sem acesso à internet ou falha na IA:** Se não houver conexão no momento do pedido, o sistema avisa que a análise não pode ser feita agora e mantém todas as tarefas intactas.

---

## Parte 3: Diagrama de Classes (Semana 3)

### 3.1. Estrutura e Encapsulamento
Todos os **atributos são privados (`-`)** para proteger os dados, e os **métodos são públicos (`+`)** para permitir a comunicação segura entre as classes.


---

## Parte 4: Sequência e Estados (Semana 4)

### 4.1. Diagrama de Sequência: Solicitar Análise Inteligente (IA)


### 4.2. Diagrama de Sequência: Criar Nova Tarefa


### 4.3. Diagrama de Estados: Classe `Tarefa`

---

## Parte 5: Visão Arquitetural — Componentes e Implantação (Semana 5)

### 5.1. Diagrama de Componentes
O diagrama abaixo mostra como o sistema **Prioriza** é dividido em blocos de software independentes e como eles se comunicam:

* **Interface Mobile (App):** Telas do aplicativo (listas, filtros, formulários e visualização das sugestões).
* **Controlador de Tarefas e Usuários (API Backend):** Regras de negócio, autenticação de login e gerenciamento das tarefas.
* **Motor de Integração com IA:** Prepara os dados das tarefas e se comunica com o serviço externo de Inteligência Artificial.
* **Banco de Dados:** Armazena usuários, categorias, tarefas e histórico de sugestões.
* **API Externa de IA:** Serviço de Inteligência Artificial na nuvem que analisa os prazos e devolve as recomendações.

---

### 5.2. Diagrama de Implantação
O diagrama de implantação mostra a infraestrutura física e em nuvem onde cada parte do sistema roda na prática:

* **Celular do Usuário (Android / iOS):** Executa o aplicativo **Prioriza** e guarda um cache local para o usuário visualizar suas tarefas mesmo se ficar sem internet.
* **Servidor de Aplicação na Nuvem:** Hospeda a API principal do sistema (autenticação, regras de tarefas e comunicação com a IA).
* **Servidor de Banco de Dados na Nuvem:** Guarda de forma segura e persistente os dados dos usuários e suas listas de tarefas.
* **Nuvem do Provedor de IA:** Infraestrutura externa (como OpenAI / Gemini) acessada via internet apenas quando o usuário solicita uma análise inteligente.
