alter table medicos add ativo BOOLEAN DEFAULT false;;
update medicos set ativo = true  WHERE ativo IS NULL;
-- 3. Torna a coluna obrigatória
ALTER TABLE medicos ALTER COLUMN telefone SET NOT NULL;
