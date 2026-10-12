# 1. Levantamento de Requisitos: Especificação de Caso de Uso

Abaixo, detalha-se a funcionalidade principal do módulo utilizando o rigor técnico exigido para sistemas financeiros.

## UC-01: Realizar Pix

### Visão Geral
* **Ator Principal:** Cliente.
* **Descrição:** O sistema permite que o ator transfira valores monetários de sua conta para um destinatário através da validação de uma chave Pix (CPF, E-mail, Telefone ou Chave Aleatória).

### Condições
* **Pré-condições:** 
  * O usuário deve estar autenticado e com a sessão ativa.
  * A conta de origem deve possuir saldo disponível.
* **Pós-condições:** 
  * O débito é efetivado na conta de origem e o crédito é sinalizado para o sistema do destinatário via BACEN.
  * Um comprovante de transação é gerado e vinculado ao histórico da conta.

### Fluxo Principal (Caminho Feliz)
1. O Cliente seleciona a opção "Realizar Pix".
2. O Sistema solicita a chave Pix do destinatário e o valor da transação.
3. O Cliente informa os dados solicitados.
4. O Sistema valida o formato da chave e a existência de saldo suficiente na conta de origem.
5. O Cliente confirma a operação mediante inserção de senha pessoal.
6. O Sistema envia a ordem de pagamento ao Banco Central (BACEN).
7. O Sistema processa o débito na conta de origem após confirmação do BACEN.
8. O Sistema gera o comprovante e exibe a mensagem de sucesso na interface.

### Fluxo de Exceção (FE-01): Saldo Insuficiente
* **Gatilho:** No passo 4 do Fluxo Principal, se o sistema verificar que o saldo em conta é inferior ao valor da transferência:
  1. O Sistema exibe mensagem de erro: *"Saldo insuficiente para realizar a operação"*.
  2. O Sistema oferece a opção de corrigir o valor ou cancelar a operação.
  3. O fluxo retorna obrigatoriamente ao passo 3 do Fluxo Principal.
