alter table pacientes add ativo BOOLEAN DEFAULT false;;
update pacientes set ativo = true  WHERE ativo IS NULL;
-- 3. Torna a coluna obrigatória
ALTER TABLE pacientes ALTER COLUMN telefone SET NOT NULL;