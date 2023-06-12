
# Eventosapp

O Eventosapp é um projeto para gerenciar eventos online e presenciais. Ele permite que os usuários criem eventos, se inscrevam em eventos existentes e interajam com outros participantes.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.0.6
- Hibernate 6.0.12.Final
- MySQL 8.0.21
- Thymeleaf
- Maven
- DevTools

## Funcionalidades

- Criar um novo evento, fornecendo detalhes como título, descrição, data, localização, etc.
- Editar um evento.
- Visualizar a lista de eventos existentes.
- Inscrever-se em eventos específicos.
- Visualizar os detalhes de um evento, incluindo a lista de participantes.
- Interagir com outros participantes do evento através de comentários.
- Atualizar dados dos participantes.

## Pré-requisitos

Certifique-se de ter as seguintes dependências instaladas em sua máquina:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) (v17 ou superior)
- [MySQL](https://www.mysql.com) (v8.0.21 ou superior)
- [Maven](https://maven.apache.org) (v3.8.3 ou superior)

## Configuração

1. Clone o repositório:

   ```bash
   git clone https://github.com/MouraYuri93/Eventosapp.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd Eventosapp
   ```

3. Configure o banco de dados MySQL. Crie um banco de dados chamado `eventosapp` e atualize as configurações de conexão em `src/main/resources/application.properties`:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/eventosapp
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

4. Execute o projeto utilizando o Maven:

   ```bash
   mvn spring-boot:run
   ```

5. Abra o navegador e acesse `http://localhost:8080` para visualizar o aplicativo.

## Contribuição

Contribuições são bem-vindas! Se você quiser contribuir com este projeto, siga as etapas abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch com a sua feature ou correção de bug: `git checkout -b minha-feature`.
3. Faça as alterações necessárias e adicione os commits: `git commit -m 'Minha nova feature'`.
4. Envie as alterações para o seu repositório remoto: `git push origin minha-feature`.
5. Envie um pull request, descrevendo as alterações propostas.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
