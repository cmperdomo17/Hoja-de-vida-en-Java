import java.util.Date;

public abstract class Ubicacion {

    private String pais;
    private String departamento;
    private String municipio;

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

    @Override
    public String toString() {
        return "Ubicacion{" +
                "pais='" + pais + '\'' +
                ", departamento='" + departamento + '\'' +
                ", municipio='" + municipio + '\'' +
                '}';
    }
}

class Nacimiento extends Ubicacion {

    private Date fecha;

    public Nacimiento(String pais, String departamento, String municipio, Date fecha) {
        super(pais, departamento, municipio);
        this.fecha = fecha;
    }

    public Date getFecha() { return fecha; }

    public void setFecha(Date fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "Nacimiento{" +
                "fecha=" + fecha +
                '}';
    }
}

class Correspondencia extends Ubicacion {

    private String direccion;
    private String email;
    private String telefono;

    public Correspondencia(String pais, String departamento, String municipio, String direccion, String email, String telefono) {
        super(pais, departamento, municipio);
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public String getDireccion() { return direccion; }

    public String getEmail() { return email; }

    public String getTelefono() { return telefono; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void setEmail(String email) { this.email = email; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "Correspondencia{" +
                "direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
