<h3 align="center">
  DESAFIO MENSAGERIA COMPASSO UOL COM RABBITMQ
</h3>


Desafio:

Desenvolver um sistema de Mensageria com RabbitMQ

<h4>Tecnologias</h4>
<h3> Java 11, Spring Boot, RabbitMQ, Gradle, Banco de dados H2, Banco de dados MongoDB,  Swagger, JUnit, JUnit e outras ferramentas</h3>
  

 Requisitos

Seu computador precisa dos seguintes requisitos para rodar o projeto: 
Java 11 (LTS), Gradle 7.0.2, Docker


 Rodando o projeto

1. Clone ou baixe o projeto do repositório para a sua máquina.

2. Vá até a raíz do seu diretório onde salvou ou clonou o projeto na pasta `consumer`, abra o `terminal e execute o comando:`
<ul> 
   <li> sudo gradle build
</ul>

3. Vá até a raíz do seu diretório onde salvou ou clonou o projeto na pasta `producer`, abra o `terminal e execute o comando:`
<ul> 
   <li> sudo gradle build
</ul>

4. Vá até a raíz do seu diretório onde salvou ou clonou o projeto, abra o `terminal e execute em sequencia os comandos:`
<ul> 
   <li> sudo docker-compose build
   <li> sudo docker-compose up
</ul>

5. Após a execução dos processos anteriores, estarão disponíveis para acesso em seu navegador os seguintes `Endpoints`:
<ul> 
  <li>
   <a href="http://localhost:9090" target="_blank">Consumer (http://localhost:9090)</a>
  <li>
   <a href="http://localhost:8080" target="_blank">Producer (http://localhost:8080)</a>
  <li>
   <a href="http://localhost:9191" target="_blank">RabbitMQ (http://localhost:9191)</a>
  <li>
   <a href="http://localhost:8081" target="_blank">Mongo Express (http://localhost:8081)</a>
</ul> 

 Executando os testes unitários

1. Vá até a raíz do seu diretório onde salvou ou clonou o projeto, abra o `terminal e execute ` o comando `sudo gradle clean test`. Este comando executará todos os casos de teste.

Detalhes da aplicação

 A aplicação `producer` tem por finalidade a produção de dados que acontece via endpoint de sua api-rest.Quando os dados são produzidos,são enviados para a fila `"queue"` no tópico `product` do `RabbitMQ` e armazenados em um banco relacional `H2DB`. Por sua vez, a aplicação `consumer` fica `ouvindo os eventos` deste `tópico` e, quando chega uma `nova mensagem` ela é `processada` e removida da fila, salvando em um banco não relacional `MongoDB` e disponibilizando-os por meio de sua api-rest.


