# 📊 Análise Comparativa de Bancos de Dados: PostgreSQL e ObjectDB

Este projeto é parte do trabalho final de Banco de Dados do Curso de Ciência da Computação da Universidade Estadual do Norte do Paraná (UENP). Ele explora e compara características, vantagens e desvantagens de bancos de dados relacionais e orientados a objetos, utilizando **PostgreSQL**, **ObjectDB** e **Mongodb** como exemplos práticos.

---

## 📚 Introdução

A crescente complexidade das aplicações e a geração exponencial de dados aumentam a demanda por sistemas de gerenciamento de bancos de dados (SGBDs) eficientes e flexíveis. Este trabalho apresenta uma análise comparativa entre dois modelos de bancos de dados:

- **Bancos de dados relacionais**: Baseados em tabelas com esquemas rígidos.
- **Bancos de dados orientados a objetos**: Utilizam objetos e classes para armazenamento e recuperação de dados.

---

## 🎯 Objetivo

O objetivo principal deste projeto é realizar uma análise prática e comparativa das linguagens e estruturas para:

- **Definição de dados**.
- **Recuperação de dados**.
- **Controle de dados (segurança)**.

Utilizando os bancos de dados **PostgreSQL** e **ObjectDB**, buscamos evidenciar as diferenças entre os modelos e identificar os cenários mais adequados para sua aplicação.

---

## 🛠 Exemplos Práticos

### 1️⃣ Banco de Dados Relacional: PostgreSQL

#### Criação de Tabela
```sql
CREATE TABLE Aluno(
   id SERIAL PRIMARY KEY,
   nome VARCHAR(100) NOT NULL,
   email VARCHAR(100) UNIQUE NOT NULL,
   data_nascimento DATE
);
```

#### Inserção de Dados
```sql
INSERT INTO Aluno (nome, email, data_nascimento)
VALUES ('João Silva', 'joao.silva@email.com', '1990-01-15');
```

#### Consulta à Tabela
```sql
SELECT * FROM Aluno;
```

#### Controle de Acesso
- **Criar usuário**:
  ```sql
  CREATE USER "João Silva" WITH PASSWORD '1234';
  ```
- **Conceder permissão de leitura**:
  ```sql
  GRANT SELECT ON Aluno TO "João Silva";
  ```

---

### 2️⃣ Banco de Dados Orientado a Objetos: ObjectDB

#### Definição de Entidade `Aluno`
```java
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private Date dataNascimento;

    // Getters e Setters
}
```

#### Consulta de Dados
```java
List<Aluno> alunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
for (Aluno aluno : alunos) {
    System.out.println("Nome: " + aluno.getNome());
}
```

#### Exclusão de Dados
```java
Aluno aluno = em.find(Aluno.class, 1L);
if (aluno != null) {
    em.getTransaction().begin();
    em.remove(aluno);
    em.getTransaction().commit();
}
```

---

## ✅ Conclusão

Este trabalho demonstra as diferenças práticas entre os modelos de banco de dados relacional e orientado a objetos. 
Enquanto o **PostgreSQL** se destaca pela estruturação rígida e robustez em transações, o **ObjectDB** oferece 
flexibilidade e integração nativa com Java, tornando-o ideal para aplicações orientadas a objetos.

---

## 💻 Requisitos do Projeto

### Tecnologias Utilizadas
- **PostgreSQL**
- **ObjectDB**
- **Java Persistence API (JPA)**

### Pré-requisitos
- Java JDK 8+.
- PostgreSQL instalado e configurado.
- Dependências configuradas no `pom.xml` para uso do ObjectDB.

---

## ✍️ Autor

**Weslem Cristiano de Oliveira**  
Orientador: Prof. Glauco Carlos Silva.  

📍 Universidade Estadual do Norte do Paraná - Centro de Ciências Tecnológicas, 2025.
```
