-- USE TesteEstagio;
-- DELETE FROM animais where id > 0;
-- DELETE FROM cuidados WHERE id > 0;

-- ALTER TABLE animais AUTO_INCREMENT = 1;
-- ALTER TABLE cuidados AUTO_INCREMENT = 1;

INSERT INTO animais (nome, descricao, data_nascimento, especie, habitat, pais_origem) VALUES
('Simba', 'Leão adulto de temperamento calmo, costuma descansar ao sol.', '2016-05-11', 'Leão-africano', 'Savanas africanas', 'Quênia'),
('Mel', 'Elefanta fêmea muito sociável, gosta de interagir com visitantes.', '2011-09-23', 'Elefante-africano', 'Áreas de savana e bosques', 'África do Sul'),
('Luna', 'Girafa jovem conhecida pelo pescoço longo e curiosidade constante.', '2019-03-07', 'Girafa', 'Savanas abertas', 'Tanzânia'),
('Tao', 'Panda tranquilo, passa grande parte do tempo alimentando-se de bambu.', '2018-01-14', 'Panda-gigante', 'Florestas de bambu', 'China'),
('Raj', 'Tigre ativo e territorial, muito atento ao ambiente.', '2015-12-02', 'Tigre-de-bengala', 'Florestas tropicais', 'Índia'),
('Kora', 'Canguru fêmea bastante ágil, costuma saltar longas distâncias.', '2020-06-29', 'Canguru-vermelho', 'Planícies abertas', 'Austrália'),
('Otto', 'Pinguim sociável, vive em grupo e adora mergulhar.', '2020-11-18', 'Pinguim-de-magalhães', 'Regiões frias costeiras', 'Argentina'),
('Jade', 'Arara colorida, muito comunicativa e com grande habilidade de voo.', '2021-08-03', 'Arara-azul', 'Floresta tropical', 'Brasil'),
('Zuri', 'Hipopótamo jovem que passa grande parte do tempo na água.', '2017-04-20', 'Hipopótamo-comum', 'Rios e lagos', 'Uganda'),
('Kodiak', 'Lobo atento e rápido, costuma uivar ao anoitecer.', '2016-10-09', 'Lobo-cinzento', 'Florestas frias', 'Canadá');

INSERT INTO cuidados (nome, descricao, frequencia) 
    VALUES
('Alimentação diária', 'Fornecimento de dieta adequada de acordo com a espécie, incluindo carnes, frutas, verduras ou rações específicas.', 'Diária'),
('Banho', 'Higienização completa do animal com produtos adequados, respeitando características do pelo e da pele.', 'Mensal'),
('Tosa', 'Corte de pelos para manutenção da higiene e conforto, geralmente em animais de pelo longo.', 'Trimestral'),
('Avaliação veterinária', 'Checagem geral da saúde do animal, incluindo exames físicos e comportamentais.', 'Mensal'),
('Vacinação', 'Aplicação de vacinas obrigatórias e preventivas conforme o calendário de cada espécie.', 'Anual'),
('Limpeza de recinto', 'Higienização e remoção de resíduos do espaço onde o animal vive.', 'Diária'),
('Enriquecimento ambiental', 'Atividades e objetos destinados a estimular os comportamentos naturais dos animais.', 'Semanal'),
('Controle de parasitas', 'Aplicação de produtos antiparasitários para prevenção de pulgas, carrapatos e vermes.', 'Trimestral'),
('Monitoramento comportamental', 'Observação e registro do comportamento para detectar sinais de estresse ou alterações.', 'Semanal'),
('Hidratação especial', 'Garantia de acesso contínuo à água fresca e suplementação hídrica em dias quentes.', 'Diária'),
('Exame odontológico', 'Avaliação e limpeza dos dentes para prevenção de problemas bucais.', 'Anual'),
('Ajuste da dieta', 'Revisão nutricional com base em mudanças de idade, peso ou saúde.', 'Semestral'),
('Treinamento cooperativo', 'Treinamentos para facilitar manuseio, exames veterinários e redução de estresse.', 'Semanal'),
('Poda de unhas ou garras', 'Corte ou desgaste controlado das garras para evitar ferimentos ou deformações.', 'Semestral'),
('Controle de temperatura do recinto', 'Monitoramento e ajustes de aquecimento ou refrigeração conforme a espécie.', 'Diária');