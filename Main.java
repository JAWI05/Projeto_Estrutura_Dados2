public class Main {
    public static void main(String[] args) {

        // Tabela Pessoas
        TabelaPessoa tabelaPessoas = new TabelaPessoa();

        // Criação de Pessoas (Motorista e Passageiro)
        Motorista motorista1 = new Motorista(101, "João", "1234", "Fiat Uno");
        Passageiro passageiro1 = new Passageiro(201, "Maria", "Financeiro");
        Passageiro passageiro2 = new Passageiro(202, "Pedro", "Vendas");
        Motorista motorista2 = new Motorista(102, "Ana", "XYZ", "Versa");

        System.out.println("--- Cadastro de Pessoas na Tabela Hash ---");
        // Inserção na Tabela Hash
        tabelaPessoas.put(motorista1);
        tabelaPessoas.put(passageiro1);
        tabelaPessoas.put(passageiro2);
        tabelaPessoas.put(motorista2);


        // Agendamentos e Inserção nas Estruturas (Lista e Árvore)

        // Criação das Listas de Agendamentos
        ListaAgendamentos listaAgendamentos = new ListaAgendamentos();
        // Criação da Árvore de Prioridade
        ArvorePrioridade arvorePrioridade = new ArvorePrioridade();

        // Criação de Agendamentos
        Agendamento agendamento1 = new Agendamento(1, "expresso", "Rua A", "Rua B", "10:00", 5, "marcado");
        Agendamento agendamento2 = new Agendamento(2, "carona", "Rua 1", "Rua 2", "11:00", 2, "marcado");
        Agendamento agendamento3 = new Agendamento(3, "executivo", "Rua Y", "Rua Z", "09:00", 5, "marcado");
        Agendamento agendamento4 = new Agendamento(4, "carona", "Rua 88", "Rua 99", "14:30", 4, "em_execucao");
        Agendamento agendamento5 = new Agendamento(5, "expresso", "Rua Atuaí", "Rua Apeninos", "16:00", 1, "finalizado");

        // Inserção na Lista (Ordem)
        listaAgendamentos.inserirNoFim(agendamento1);
        listaAgendamentos.inserirNoFim(agendamento2);
        listaAgendamentos.inserirNoFim(agendamento3);
        listaAgendamentos.inserirNoFim(agendamento4);
        listaAgendamentos.inserirNoFim(agendamento5);

        // Inserção na Árvore Prioridades
        arvorePrioridade.inserir(agendamento1);
        arvorePrioridade.inserir(agendamento2);
        arvorePrioridade.inserir(agendamento3);
        arvorePrioridade.inserir(agendamento4);
        arvorePrioridade.inserir(agendamento5);


        // 3. Testes de Funcionalidades Base

        // Lista de Agendamentos (Ordem de Inserção)
        System.out.println("--- Lista de Agendamentos (Ordem de Inserção) ---");
        listaAgendamentos.listar(null);

        // Lista por Prioridade (In-Order Reverso: 5 -> 1)
        System.out.println("\n--- Árvore de Prioridade ---");
        arvorePrioridade.listarPorPrioridade();

        // Atribuição de Agendamento
        System.out.println("\n--- Atribuição de Agendamento ---");
        // Atribuir agendamento 1
        motorista1.adicionarAgendamento(agendamento1);
        passageiro1.adicionarAgendamento(agendamento1);
        // Atribuir agendamento 4
        motorista2.adicionarAgendamento(agendamento4);
        passageiro2.adicionarAgendamento(agendamento4);

        System.out.println("\n--- Características do Motorista ID 101 ---");
        System.out.println(tabelaPessoas.get(101));
        System.out.println("Agendamentos: " + motorista1.getAgendamentosAtribuidos().size());

        System.out.println("\n--- Características do Passageiro ID 202 ---");
        System.out.println(tabelaPessoas.get(202));
        System.out.println("Agendamentos: " + passageiro2.getAgendamentosAtribuidos().size());

        // Filtrar por Status
        System.out.println("\n--- Filtrar por Status 'marcado' ---");
        listaAgendamentos.listar("marcado");

        // Remove (Agendamento ID 3)
        System.out.println("\n--- Remoção (Agendamento ID 3) ---");
        Agendamento agendamentoRemovidoLista = listaAgendamentos.removerPorId(3);
        Agendamento agendamentoRemovidoArvore = arvorePrioridade.removerPorId(3);

        if (agendamentoRemovidoLista != null && agendamentoRemovidoArvore != null) {
            System.out.println("-> Agendamento ID 3 removido com sucesso.");
        } else {
            System.out.println("Agendamento ID 3 não foi removido.");
        }

        // Listagem Pós-Remoção
        System.out.println("\n--- Lista de Agendamentos (sem ID 3) ---");
        listaAgendamentos.listar(null);

        System.out.println("\n--- Árvore de Prioridade (sem ID 3) ---");
        arvorePrioridade.listarPorPrioridade();
    }
}