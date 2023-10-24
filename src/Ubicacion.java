public abstract class Ubicacion {

    private String pais;
    private String departamento;
    private String municipio;

    public Ubicacion() {
    }

    public Ubicacion(String pais, String departamento, String municipio) {
        this.pais = pais;
        this.departamento = departamento;
        this.municipio = municipio;
    }

    public String getPais() { return pais; }

    public String getDepartamento() { return departamento; }

    public String getMunicipio() { return municipio; }

    public void setPais(String pais) { this.pais = pais; }

    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public void setMunicipio(String municipio) { this.municipio = municipio; }

}

class Nacimiento extends Ubicacion {

    public Nacimiento() {
    }

    public Nacimiento(String pais, String departamento, String municipio) {
        super(pais, departamento, municipio);
    }

}

class Correspondencia extends Ubicacion {

    public Correspondencia() {
    }

    public Correspondencia(String pais, String departamento, String municipio) {
        super(pais, departamento, municipio);
    }

}
