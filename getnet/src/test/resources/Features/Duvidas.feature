Feature: Verificar o fluxo de pesquisa e duvidas do site

  Scenario Outline: Como Acessar Minha Conta Superget
    Given Como posso acessar minha conta superget
    When Clicar no icone de pesquisa
    And Digitar '<textoBusca>' e clicar em procurar
    Then Sistema apresenta as duvidas mais frequentes '<textoBusca>'
    And Eu clico no link '<textoDuvida>'
    And Verifico se o titulo da modal apresenta a frase '<textoDuvida>'

    Examples: 
      | textoBusca | textoDuvida                                                  |
      | superget   | Como acesso a minha conta SuperGet?                          |
      | superget   | Consigo visualizar minhas vendas no meu aplicativo SuperGet? |
