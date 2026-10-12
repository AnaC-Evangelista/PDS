# Especificação de Caso de Uso: UC-01

## 1. Visão Geral
* **ID do Caso de Uso:** UC-01
* **Nome:** Solicitar Análise Inteligente
* **Atores:** Usuário e IA
* **Descrição:** Esse caso de uso permite que o usuário solicite uma análise de suas tarefas. A IA analisa as atividades e sugere prioridades, organização e uma melhor ordem de execução, ajudando o usuário a melhorar sua produtividade e evitar esquecimentos.

## 2. Condições
### Pré-condições
1. O usuário deve estar logado no sistema.
2. O usuário deve possuir pelo menos duas tarefas cadastradas.

### Pós-condições
1. O sistema apresenta ao usuário sugestões de organização e priorização.
2. O usuário pode visualizar as recomendações geradas pela IA.
3. Caso o usuário aceite alguma sugestão, as alterações são aplicadas às tarefas correspondentes.

## 3. Fluxos de Eventos

### Fluxo Principal (Caminho Feliz)
1. O usuário solicita uma análise inteligente de suas tarefas.
2. A IA analisa as tarefas e identifica possíveis melhorias na organização.
3. O Sistema apresenta ao usuário as sugestões geradas.
4. O usuário visualiza as recomendações e decide se deseja aplicar.
5. O Sistema aplica as sugestões selecionadas pelo usuário.
6. O Sistema informa ao Usuário que a análise e as alterações foram concluídas.

### Fluxos Alternativos

#### FA-01: Analisar apenas algumas tarefas
Ao solicitar a análise:
1. O usuário seleciona as tarefas que deseja analisar.
2. O sistema envia somente as tarefas selecionadas para a IA.
3. A IA apresenta sugestões relacionadas às tarefas escolhidas.

#### FA-02: Tarefas não concluídas dentro do prazo
No momento da análise das tarefas:
1. O sistema identifica tarefas que estão atrasadas.
2. A IA considera essas tarefas na análise.
3. O sistema sugere novas prioridades ou reorganização das tarefas atrasadas.
4. O usuário visualiza as sugestões e decide se deseja aplicá-las.

### Fluxos de Exceção

#### FE-01: Usuário não possui tarefas suficientes cadastradas
No passo 2 do Fluxo Principal, caso não existam tarefas cadastradas:
1. O Sistema informa ao usuário que não existem tarefas suficientes para realizar uma análise.
2. O Sistema orienta o usuário a cadastrar pelo menos duas tarefas.
3. O caso de uso é encerrado.

#### FE-02: Usuário sem acesso à internet
No momento da solicitação da análise:
1. O sistema identifica que não há conexão com a internet.
2. O sistema informa ao usuário que não é possível realizar a análise da IA sem conexão.
3. Nenhuma alteração é realizada nas tarefas.
4. O caso de uso é encerrado.

## 4. Requisitos Especiais
* **Preservação de Dados:** O Sistema deve preservar as informações das tarefas durante o processo de análise.
* **Intervenção Humana:** As sugestões geradas pela IA não devem alterar automaticamente as tarefas sem a confirmação do usuário.
* **Segurança:** As informações enviadas ao Serviço de IA devem ser tratadas de forma segura.
* **Tolerância a Falhas:** Em caso de falha no Serviço de IA, as tarefas já cadastradas não devem ser perdidas ou alteradas.
