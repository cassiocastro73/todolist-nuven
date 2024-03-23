# To do list application

Este é um projeto feito com Spring Boot com o objetivo de ser uma api de criação de Todo list. 
O projeto tem por objetivo ser uma aplicação simples que mostra o basico do funcionamento de uma api RESTful com Spring Boot.



## Observações importantes
- Não foram desenvolvidos teste automatizados para esta aplicação.
- O projeto foi desenvolvido em um curto período de tempo.

# Para executar a Aplicação

- Clone o repositório em sua máquina: 
  > `git clone https://github.com/cassiocastro73/todolist-nuven.git`

- Navegue até o diretório do projeto:
  > `cd ../todo-list-java`

- Compile o projeto usando o Maven:
  > `mvn clean install`
  
- Vá até src\main\java\com\castrodev\desafioToDoList e execute a classe DesafioToDoListApplication
  
- Documentação também disponivel em http://localhost:8080/swagger-ui/index.htm (com a aplicação em execução)
  
- Para fazer requisições use http://localhost:8080/todos


# Funcionalidades
- Criar uma nova atividade.
- Visualizar todas as atividades criadas.
- Atualizar uma atividade.
- Apagar uma atividade da lista. 

# Tecnologias Utilizadas
- Java 17: Versão da linguagem que foi utilizada no projeto.
- Spring Boot: para a configuração da aplicação e injeção de dependências. (Versão 3.2.3)
- JPA (Java Persistence API): para mapeamento objeto-relacional (ORM) e persistência de dados.
- H2: banco de dados relacional usado no desenvolvimento e para teste.
