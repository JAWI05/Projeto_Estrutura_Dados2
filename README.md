# 🚛 Sistema de Gerenciamento de Transporte e Logística Corporativa

Este projeto robusto simula um ambiente real de logística corporativa, otimizando o fluxo de viagens entre motoristas e passageiros. O sistema foca na aplicação prática de estruturas de dados dinâmicas e princípios avançados de Programação Orientada a Objetos (POO) em Java para garantir escalabilidade e alta performance.

---

## 🛠️ Destaques Técnicos e Estruturas Implementadas

### 🌳 Árvore Binária de Busca (BST) por Prioridade
Gerenciamento da urgência dos agendamentos em níveis de 1 a 5.
*   **Lógica**: Utiliza recursão para inserção, busca e remoção de viagens com base no nível de prioridade.
*   **Eficiência**: Garante que as viagens mais críticas sejam processadas primeiro através de travessias sistemáticas (Inorder, Preorder, Postorder).
*   **Nós Dinâmicos**: Cada nó armazena o objeto da viagem e referências para as subárvores de maior ou menor urgência.



### 🔗 Lista Duplamente Encadeada para Navegação
A `ListaAgendamentos` permite o gerenciamento temporal do fluxo de viagens.
*   **Navegação Bidirecional**: Uso de ponteiros `anterior` e `proximo` para permitir a visualização de históricos e navegação reversa.
*   **Manipulação**: Inserções e remoções eficientes no início e fim da lista para rastreio de viagens em tempo real.



### 🔑 Tabela Hash para Gestão de Usuários
Indexação de motoristas e passageiros por IDs únicos.
*   **Performance**: Acesso aos dados cadastrais em tempo constante $O(1)$.
*   **Escalabilidade**: Estrutura otimizada para busca rápida em grandes volumes de registros de usuários.

### 🏗️ Arquitetura Orientada a Objetos (POO)
*   **Abstração e Herança**: Classe abstrata `Pessoa` como base para `Motorista` e `Passageiro`, promovendo o reuso de código.
*   **Polimorfismo**: Tratamento dinâmico de atributos específicos como veículos e departamentos.
*   **Encapsulamento**: Uso rigoroso de modificadores de acesso e métodos acessores para integridade dos dados.

---
