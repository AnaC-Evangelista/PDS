# Tarefa 1 – Casos de Uso

## A. Atores do Sistema
* **Cliente:** Consulta o cardápio, escolhe produtos, informa quantidades, fecha o pedido e realiza o pagamento.
* **Atendente:** Registra a venda, recebe o pagamento e emite o comprovante simples.
* **Gerente:** Cadastra novos produtos, altera preços, atualiza estoques e remove produtos do cardápio.

---

## B. Lista dos Casos de Uso Principais
* **UC-01:** Consultar Cardápio (Ator: Cliente)
* **UC-02:** Realizar Pedido / Registrar Venda (Atores: Atendente, Cliente)
* **UC-03:** Processar Pagamento (Atores: Atendente, Cliente)
* **UC-04:** Gerenciar Produtos (Ator: Gerente)
* **UC-05:** Consultar Vendas Realizadas (Ator: Gerente)

---

## C. Descrição Textual dos Casos de Uso

### Especificação do UC-02: Realizar Pedido
* **ID do Caso de Uso:** UC-02
* **Nome:** Realizar Pedido
* **Atores:** Atendente (Ator Principal), Cliente
* **Objetivo:** Permitir a seleção de itens do cardápio, criação do pedido e cálculo automático do valor total.
* **Pré-condições:** O sistema deve estar em operação e os produtos cadastrados no cardápio.
* **Pós-condições:** Um pedido contendo os itens selecionados é registrado e disponibilizado para quitação financeira.

#### Fluxo Principal (Caminho Feliz)
1. O Atendente inicia um novo pedido no sistema.
2. O Atendente informa o produto solicitado e a quantidade desejada pelo Cliente.
3. O Sistema verifica se há quantidade suficiente em estoque do produto.
4. O Sistema cria o item do pedido, calcula o subtotal (preço unitário × quantidade) e adiciona o item ao pedido.
5. Os passos 2 a 4 repetem-se para cada item solicitado pelo Cliente.
6. O Atendente solicita o encerramento da inclusão de itens.
7. O Sistema calcula e exibe o valor total acumulado do pedido somando os subtotais.

#### Fluxo de Exceção (FE-01: Estoque Insuficiente)
* **No passo 3**, se a quantidade solicitada for maior que o estoque disponível:
  1. O Sistema exibe uma mensagem de erro informando que o produto não possui estoque suficiente.
  2. O item não é adicionado ao pedido.
  3. O Atendente pode optar por ajustar a quantidade ou selecionar outro produto, retornando ao passo 2 do fluxo principal.

---

### Especificação do UC-03: Processar Pagamento
* **ID do Caso de Uso:** UC-03
* **Nome:** Processar Pagamento
* **Atores:** Atendente (Ator Principal), Cliente
* **Objetivo:** Receber a forma de pagamento, verificar a suficiência do valor, calcular o troco e encerrar a compra.
* **Pré-condições:** O pedido deve conter pelo menos um item e possuir valor total calculado.
* **Pós-condições:** O pagamento é confirmado, os estoques dos produtos vendidos são atualizados, a data/hora da venda é gravada e o comprovante é emitido.

#### Fluxo Principal (Caminho Feliz)
1. O Atendente seleciona o tipo de pagamento (Dinheiro, PIX, Cartão de Crédito ou Débito).
2. O Atendente insere o valor fornecido/pago pelo Cliente.
3. O Sistema valida se o valor pago é igual ou superior ao total do pedido.
4. O Sistema calcula o troco (se a forma for dinheiro).
5. O Sistema baixa os estoques dos produtos, registra a data e hora da venda e emite o comprovante.

#### Fluxo de Exceção (FE-01: Valor Pago Insuficiente)
* **No passo 3**, se o valor pago for menor que o total do pedido:
  1. O Sistema exibe a mensagem "Valor pago insuficiente para cobrir o total do pedido".
  2. O pagamento não é aprovado e o pedido não é finalizado.
  3. O Atendente solicita ao cliente o complemento do valor ou alteração da forma de pagamento.
