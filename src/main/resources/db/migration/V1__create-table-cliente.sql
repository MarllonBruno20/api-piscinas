CREATE TABLE IF NOT EXISTS public.cliente
(
    codigo bigserial NOT NULL,
    nome text,
    contato text,
    endereco text,
    situacao text DEFAULT 'ATIVO',
    PRIMARY KEY (codigo)
    );