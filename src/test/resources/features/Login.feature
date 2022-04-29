#language:pt
@test
  Funcionalidade: Teste login Bugbank

    Cenario: Login com sucesso - 1
      Dado que esteja na pagina inicial: "http://localhost:3000"
      E possuo cadastro
      Quando preencher email: "teste10@teste.com.br" e senha: "teste"
      E clicar em fazer login
      Entao valido que a pagina de boas vindas foi carregada com sucesso

    Cenario: Login com sucesso - 2
      Dado que esteja na pagina inicial: "http://localhost:3000"
      E possuo cadastro
      Quando preencher email: "teste10@teste.com.br" e senha: "teste"
      E clicar em fazer login
      Entao valido que a pagina de boas vindas foi carregada com sucesso

@wip
    Cenario: Login com sucesso - 3
      Dado que esteja na pagina inicial: "http://localhost:3000"
      E possuo cadastro
      Quando preencher email: "teste10@teste.com.br" e senha: "teste"
      E clicar em fazer login
      Entao valido que a pagina de boas vindas foi carregada com sucesso
