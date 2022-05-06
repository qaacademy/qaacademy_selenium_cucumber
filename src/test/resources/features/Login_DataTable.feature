#language:pt

Funcionalidade: Teste login Bugbank

  Cenario: Login com sucesso
    Dado que esteja na pagina inicial: "http://localhost:3000"
    E preencho o cadastro com os dados
      | Email                | Nome       | Senha | Confirmacao |
      | teste10@teste.com.br | QA Academy | teste | teste       |
      | teste20@teste.com.br | QA Academy | teste | teste       |
      | teste30@teste.com.br | QA Academy | teste | teste       |

    Quando preencher email: "teste10@teste.com.br" e senha: "teste"
    E clicar em fazer login
    Entao valido que a pagina de boas vindas foi carregada com sucesso