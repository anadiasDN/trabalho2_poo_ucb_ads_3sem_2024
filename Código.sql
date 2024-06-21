--criar um database com nome lojadcroche, usuário root e sem senha

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(20),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL
);

CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE detalhes_pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    produto_id INT,
    quantidade INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

-- Inserindo dados na tabela cliente (exemplo de clientes da loja)
INSERT INTO cliente (nome, email, telefone, endereco, cidade, estado, cep)
VALUES
    ('Ana Silva', 'ana@example.com', '1122334455', 'Rua das Agulhas, 123', 'São Paulo', 'SP', '01234-567'),
    ('Carla Souza', 'carla@example.com', '9988776655', 'Av. dos Fios, 456', 'Rio de Janeiro', 'RJ', '21000-000'),
    ('Pedro Oliveira', 'pedro@example.com', '5544332211', 'Rua das Linhas, 789', 'Belo Horizonte', 'MG', '30000-123');

-- Inserindo dados na tabela produto (exemplos de produtos de crochê)
INSERT INTO produto (nome, descricao, preco, quantidade)
VALUES
    ('Cachecol de Crochê', 'Cachecol feito à mão com fios de lã', 49.99, 20),
    ('Touca Infantil', 'Touca de crochê para crianças', 29.90, 30),
    ('Manta Decorativa', 'Manta para sofá em crochê colorido', 119.99, 15),
    ('Bolsa de Praia', 'Bolsa espaçosa para praia, feita de crochê', 89.50, 25);

-- Inserindo dados na tabela pedido (exemplo de pedidos feitos)
INSERT INTO pedido (cliente_id, total)
VALUES
    (1, 79.98),  -- Pedido da cliente Ana Silva
    (2, 149.80); -- Pedido da cliente Carla Souza

-- Inserindo dados na tabela detalhes_pedido (exemplo de detalhes dos pedidos)
-- Detalhes do pedido da Ana Silva
INSERT INTO detalhes_pedido (pedido_id, produto_id, quantidade, preco)
VALUES
    (1, 1, 1, 49.99),  -- 1 cachecol de crochê
    (1, 2, 2, 59.80);  -- 2 toucas infantis

-- Detalhes do pedido da Carla Souza
INSERT INTO detalhes_pedido (pedido_id, produto_id, quantidade, preco)
VALUES
    (2, 3, 1, 119.99),  -- 1 manta decorativa
    (2, 4, 1, 89.50);   -- 1 bolsa de praia
