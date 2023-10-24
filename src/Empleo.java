import java.util.Date;

public class Empleo {
    
    public enum tipoEmpresa {
        PUBLICA, PRIVADA
    }

    private String nombreEmpresa;
    private tipoEmpresa tipoEmpresa;
    private String email;
    private String telefono;
    private String direccion;
    private String cargoActual;
    private String dependencia;
    private Date fechaIngreso;
    private Date fechaRetiro;

    public Empleo() {
    }

    public Empleo(String nombreEmpresa, tipoEmpresa tipoEmpresa, String email, String telefono, String direccion, String cargoActual, String dependencia, Date fechaIngreso, Date fechaRetiro) {
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cargoActual = cargoActual;
        this.dependencia = dependencia;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
    }

    public String getNombreEmpresa() { return nombreEmpresa; }

    public tipoEmpresa getTipoEmpresa() { return tipoEmpresa; }

    public String getEmail() { return email; }

    public String getTelefono() { return telefono; }

    public String getDireccion() { return direccion; }

    public String getCargoActual() { return cargoActual; }

    public String getDependencia() { return dependencia; }

    public Date getFechaIngreso() { return fechaIngreso; }

    public Date getFechaRetiro() { return fechaRetiro; }

    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public void setTipoEmpresa(tipoEmpresa tipoEmpresa) { this.tipoEmpresa = tipoEmpresa; }

    public void setEmail(String email) { this.email = email; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void setCargoActual(String cargoActual) { this.cargoActual = cargoActual; }

    public void setDependencia(String dependencia) { this.dependencia = dependencia; }

    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public void setFechaRetiro(Date fechaRetiro) { this.fechaRetiro = fechaRetiro; }

    // TODO: Implementar
    public void calcularExperiencia(){

    }
}
