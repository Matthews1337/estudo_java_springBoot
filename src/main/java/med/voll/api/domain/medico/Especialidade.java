package med.voll.api.domain.medico;

public enum Especialidade {
    ORTOPEDIA("ortopedia"),
    CARDIOLOGIA("cardiologia"),
    GINECOLOGIA("ginecologia"),
    DERMATOLOGIA("dermatologia");

    private String especialidade;

    Especialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public Especialidade fromString(String especialidade){
        for (Especialidade espec: Especialidade.values()){
            if(espec.especialidade.equalsIgnoreCase(especialidade)){
                return espec;
            }
        }
        throw new IllegalArgumentException("Nenhuma especialidade encontrada para a string");
    }
}
