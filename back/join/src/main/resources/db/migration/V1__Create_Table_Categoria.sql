CREATE TABLE categoria (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),  
    nome VARCHAR(255) NOT NULL                    
);

CREATE INDEX idx_categoria_nome ON categoria (nome);