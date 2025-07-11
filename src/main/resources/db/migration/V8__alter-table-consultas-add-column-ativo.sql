alter table consultas add ativo BOOLEAN DEFAULT true;;
update consultas set ativo = true  WHERE ativo IS NULL;
-- 3. Torna a coluna obrigatória
ALTER TABLE consultas ALTER COLUMN ativo SET NOT NULL;
