--MYSQL
--CREATE table consultas(
--    id bigint not null auto_increment,
--    medico_id bigint not null,
--    paciente_id bigint not null,
--    DATA datetime NOT NULL,
--
--    primary key (id),
--    constraint fk_consultas_medico_id foreign key(medico_id) references medicos(id),
--    constraint fk_consultas_paciente_id foreign key(paciente_id) references pacientes(id),
--
--)
CREATE TABLE consultas (
    id BIGSERIAL PRIMARY KEY,
    medico_id BIGINT NOT NULL,
    paciente_id BIGINT NOT NULL,
    data TIMESTAMP NOT NULL,

    CONSTRAINT fk_consultas_medico_id FOREIGN KEY (medico_id) REFERENCES medicos(id),
    CONSTRAINT fk_consultas_paciente_id FOREIGN KEY (paciente_id) REFERENCES pacientes(id)
);