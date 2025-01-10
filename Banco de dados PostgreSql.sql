-- Criação do Banco de dados Comparativas
create database Comparativas;

-- Criação de uma tabela Aluno
CREATE TABLE Aluno(
   id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    data_nascimento DATE
);

-- Inserir dados
INSERT INTO Aluno (nome, email, data_nascimento)
VALUES ('João Silva', 'joao.silva@email.com', '1990-01-15');

-- Inserir dados
INSERT INTO Aluno (nome, email, data_nascimento)
VALUES ('Maria Souza', 'maria.souza@email.com', '1995-07-20');

-- Inserir dados
INSERT INTO Aluno (nome, email, data_nascimento)
VALUES ('Pedro Santos', 'pedro.santos@email.com', '2000-12-05');

-- Recuperar todos os Alunos com idade maior que 30
SELECT nome, email
FROM Aluno
WHERE AGE(data_nascimento) > '30 years';

--Criar um usuário
CREATE USER "João Silva" WITH PASSWORD '1234';

-- Conceder permissão de leitura para um usuário
GRANT SELECT ON Aluno TO "João Silva";

-- Revogar permissões
REVOKE INSERT ON Aluno FROM "João Silva";




