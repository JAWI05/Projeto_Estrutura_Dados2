public class TabelaPessoa {
    private static final int TAMANHO_TABELA = 10;
    public NoHash[] tabela;

    public TabelaPessoa() {
        this.tabela = new NoHash[TAMANHO_TABELA];
    }

    private int hash(int id) {
        return id % TAMANHO_TABELA;
    }

    // Insere uma Pessoa na Tabela

    public void put(Pessoa pessoa) {
        if (pessoa == null) return;

        int indice = hash(pessoa.getId());
        NoHash novoNo = new NoHash(pessoa);

        NoHash atual = tabela[indice];
        while (atual != null) {
            if (atual.pessoa.getId() == pessoa.getId()) {
                System.out.println("[TabelaPessoas] Aviso: Pessoa com ID " + pessoa.getId() + " já está na tabela.");
                return;
            }
            atual = atual.proximo;
        }

        novoNo.proximo = tabela[indice];
        tabela[indice] = novoNo;
    }

    /*
     Busca uma Pessoa pelo seu ID (get).
     ID da pessoa.
     return a Pessoa encontrada, ou null se não for encontrada.
     */

    public Pessoa get(int id) {
        int indice = hash(id);
        NoHash atual = tabela[indice];

        while (atual != null) {
            if (atual.pessoa.getId() == id) {
                return atual.pessoa;
            }
            atual = atual.proximo;
        }
        return null;
    }

    /*
     Remove uma Pessoa da Tabela Hash pelo seu ID (remove).
     Limpa os agendamentos atribuídos à pessoa antes de removê-la da Tabela.
     return A Pessoa removida, ou null se não for encontrada.
     */
    public Pessoa remove(int id) {
        int indice = hash(id);
        NoHash atual = tabela[indice];
        NoHash anterior = null;

        while (atual != null) {
            if (atual.pessoa.getId() == id) {
                // Pessoa encontrada
                Pessoa pessoaRemovida = atual.pessoa;

                if (anterior == null) {
                    tabela[indice] = atual.proximo; // Primeiro nó no bucket
                } else {
                    anterior.proximo = atual.proximo; // Meio ou fim do bucket
                }

                // Limpa quaisquer agendamentos atribuídos da pessoa
                pessoaRemovida.getAgendamentosAtribuidos().clear();

                return pessoaRemovida;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return null; // Pessoa não encontrada
    }
}