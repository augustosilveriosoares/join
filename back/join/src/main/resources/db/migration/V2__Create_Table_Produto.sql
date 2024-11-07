CREATE TABLE public.produto (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),  -- UUID gerado automaticamente
    nome VARCHAR(255) NOT NULL,                     -- Nome do produto
    sku VARCHAR(100) NOT NULL,                      -- SKU do produto
    preco DECIMAL(10, 2) NOT NULL,                  -- Preço do produto
    categoria_id UUID NOT NULL,                     -- Chave estrangeira para a categoria
    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id)
        REFERENCES public.categoria (id)          -- Relacionamento com a tabela categoria
        ON DELETE CASCADE
);

CREATE INDEX idx_produto_categoria_id ON produto (categoria_id);