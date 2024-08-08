CREATE TABLE IF NOT EXISTS public.piscina
(
    codigo bigserial NOT NULL,
    endereco text,
    tempo_medio integer,
    codigo_cliente bigint REFERENCES cliente(codigo) NOT NULL,
    situacao text DEFAULT 'ATIVO',
    PRIMARY KEY (codigo)
    );
