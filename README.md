# Workshop - API de Posts e Comentários (Java + Spring Boot)

Este projeto foi desenvolvido como parte de um workshop prático de backend em Java utilizando Spring Boot.  
O objetivo é ensinar de forma clara e direta como construir uma API REST com:

- CRUD de Posts
- CRUD de Comentários vinculados a Posts
- Relacionamento One-to-Many
- Persistência com Spring Data JPA
- Banco em memória H2
- Endpoints completos para testes em Postman ou Insomnia

---

# Indice

1. Descrição do Projeto  
2. Tecnologias Utilizadas  
3. Arquitetura e Entidades  
4. Endpoints da API  
5. Exemplos de Requisição  
6. Como Executar o Projeto  
7. Estrutura de Pastas  
8. Banco H2  
9. Próximos Passos  
10. Licença  

---

# Descrição do Projeto

Esta API demonstra os fundamentos do desenvolvimento backend em Java com Spring Boot, incluindo:

- Estrutura de rotas REST
- Persistência com Spring Data JPA
- Relacionamento entre tabelas utilizando JPA/Hibernate
- Banco em memória para rápido desenvolvimento
- Testes simples usando Postman ou Insomnia

---

# Tecnologias Utilizadas

- Java 17 ou superior
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Banco H2
- Hibernate
- Maven

---

# Arquitetura e Entidades

## Entidade Post

```java
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String conteudo;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;
}


@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}



Endpoints da API
Posts
Metodo	Rota	Descricao
POST	/posts	Criar post
GET	/posts	Listar todos os posts
GET	/posts/{id}	Buscar post por ID
Comentarios
Metodo	Rota	Descricao
POST	/posts/{idPost}/comentarios	Criar comentario vinculado a um post
GET	/posts/{idPost}/comentarios	Listar comentarios de um post
GET	/comentarios/{id}	Buscar comentario por ID
Exemplos de Requisição
Criar Post
{
  "titulo": "Meu primeiro post",
  "conteudo": "Conteudo do post"
}

Criar Comentario
{
  "autor": "Tavares",
  "mensagem": "Excelente conteudo"
}

Listar Comentarios de um Post
[
  {
    "id": 1,
    "autor": "Tavares",
    "mensagem": "Excelente conteudo",
    "post": 1
  }
]

Como Executar o Projeto

Clonar o repositorio:

git clone https://github.com/seu-usuario/workshop-posts-comments.git


Entrar na pasta do projeto:

cd workshop-posts-comments


Rodar o projeto com Maven:

mvn spring-boot:run


A API ficara disponivel em:

http://localhost:8080

Estrutura de Pastas
src/
 └── main/
     ├── java/
     │    └── com.seuprojeto/
     │         ├── controller/
     │         │     ├── PostController.java
     │         │     └── ComentarioController.java
     │         ├── entity/
     │         │     ├── Post.java
     │         │     └── Comentario.java
     │         ├── repository/
     │         │     ├── PostRepository.java
     │         │     └── ComentarioRepository.java
     │         └── WorkshopApplication.java
     └── resources/
          ├── application.properties
          └── data.sql (opcional)
