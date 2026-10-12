import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaPedidos {

    // --- CLASSE PRODUTO ---
    public static class Produto {
        private int codigo;
        private String nome;
        private String categoria;
        private double precoUnitario;
        private int quantidadeEstoque;

        public Produto(int codigo, String nome, String categoria, double precoUnitario, int quantidadeEstoque) {
            this.codigo = codigo;
            this.nome = nome;
            this.categoria = categoria;
            this.precoUnitario = precoUnitario;
            this.quantidadeEstoque = quantidadeEstoque;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getNome() {
            return nome;
        }

        public String getCategoria() {
            return categoria;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        public void setPrecoUnitario(double precoUnitario) {
            this.precoUnitario = precoUnitario;
        }

        public int getQuantidadeEstoque() {
            return quantidadeEstoque;
        }

        public boolean temEstoqueSuficiente(int quantidade) {
            return this.quantidadeEstoque >= quantidade;
        }

        public void deduzirEstoque(int quantidade) {
            if (temEstoqueSuficiente(quantidade)) {
                this.quantidadeEstoque -= quantidade;
            } else {
                throw new IllegalArgumentException("Estoque insuficiente para o produto: " + nome);
            }
        }

        public void atualizarEstoque(int quantidade) {
            this.quantidadeEstoque += quantidade;
        }
    }

    // --- CLASSE ITEM PEDIDO ---
    public static class ItemPedido {
        private Produto produto;
        private int quantidade;

        public ItemPedido(Produto produto, int quantidade) {
            if (produto == null) {
                throw new IllegalArgumentException("Produto nao pode ser nulo.");
            }
            if (quantidade <= 0) {
                throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
            }
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Produto getProduto() {
            return produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public double calcularSubtotal() {
            return produto.getPrecoUnitario() * quantidade;
        }
    }

    // --- CLASSE PEDIDO ---
    public static class Pedido {
        private int id;
        private LocalDateTime dataHora;
        private List<ItemPedido> itens;
        private boolean finalizado;

        public Pedido(int id) {
            this.id = id;
            this.dataHora = LocalDateTime.now();
            this.itens = new ArrayList<>();
            this.finalizado = false;
        }

        public int getId() {
            return id;
        }

        public LocalDateTime getDataHora() {
            return dataHora;
        }

        public List<ItemPedido> getItens() {
            return itens;
        }

        public boolean isFinalizado() {
            return finalizado;
        }

        public void adicionarItem(ItemPedido item) {
            if (finalizado) {
                throw new IllegalStateException("Nao e possivel adicionar itens a um pedido finalizado.");
            }
            if (item == null) {
                throw new IllegalArgumentException("Item do pedido nao pode ser nulo.");
            }
            this.itens.add(item);
        }

        public double calcularTotal() {
            double total = 0.0;
            for (ItemPedido item : itens) {
                total += item.calcularSubtotal();
            }
            return total;
        }

        public void finalizarPedido() {
            if (finalizado) {
                throw new IllegalStateException("O pedido ja esta finalizado.");
            }
            if (itens.isEmpty()) {
                throw new IllegalStateException("Nao e possivel finalizar um pedido sem itens.");
            }

            // Verifica e deduz o estoque de todos os itens
            for (ItemPedido item : itens) {
                Produto produto = item.getProduto();
                int qtdDesejada = item.getQuantidade();

                if (!produto.temEstoqueSuficiente(qtdDesejada)) {
                    throw new IllegalStateException("Estoque insuficiente para o produto: " + produto.getNome());
                }
            }

            // Se tudo estiver OK, deduz efetivamente
            for (ItemPedido item : itens) {
                item.getProduto().deduzirEstoque(item.getQuantidade());
            }

            this.finalizado = true;
        }
    }

    // --- MÉTODO MAIN PARA TESTES ---
    public static void main(String[] args) {
        System.out.println("--- Testando o Sistema de Pedidos ---");

        // Criando produtos
        Produto p1 = new Produto(1, "Notebook", "Eletronicos", 3500.00, 10);
        Produto p2 = new Produto(2, "Mouse Sem Fio", "Eletronicos", 150.00, 20);

        // Criando um pedido
        Pedido pedido = new Pedido(101);

        // Adicionando itens
        pedido.adicionarItem(new ItemPedido(p1, 1));
        pedido.adicionarItem(new ItemPedido(p2, 2));

        System.out.println("Valor total do pedido: R$ " + pedido.calcularTotal());

        // Finalizando o pedido
        pedido.finalizarPedido();
        System.out.println("Pedido finalizado com sucesso!");

        // Verificando estoque atualizado
        System.out.println("Estoque restante de Notebook: " + p1.getQuantidadeEstoque() + " unidades.");
        System.out.println("Estoque restante de Mouse: " + p2.getQuantidadeEstoque() + " unidades.");
    }
}