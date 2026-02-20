CREATE TABLE IF NOT EXISTS animais(
    'id' INT PRIMARY_KEY NOT_NULL AUTO_INCREMENT,
    'nome' VARCHAR(255),
    'descricao' VARCHAR(255),
    'data_nascimento' DATE
    'especie' VARCHAR(255),
    'habitat' VARCHAR(255),    
    'pais_origem' VARCHAR(255),
    
);

CREATE TABLE IF NOT EXISTS cuidados(
    'id' INT PRIMARY_KEY NOT_NULL AUTO_INCREMENT,
    'nome' VARCHAR(255),
    'descricao' VARCHAR(255),
    'frequencia' VARCHAR(255)
);