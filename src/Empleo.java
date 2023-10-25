import java.time.LocalDate;
import java.time.Period;

public class Empleo {
    
    public enum TipoEmpresa {
        PUBLICA, PRIVADA
    }

    private String nombreEmpresa;
    private TipoEmpresa tipoEmpresa;
    private String email;
    private String telefono;
    private String direccion;
    private String cargoActual;
    private String dependencia;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;

    public Empleo(String nombreEmpresa, TipoEmpresa tipoEmpresa, String email, String telefono, String direccion, String cargoActual, String dependencia, int anioIngreso, int mesIngreso, Integer anioRetiro, Integer mesRetiro) {
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cargoActual = cargoActual;
        this.dependencia = dependencia;
        this.fechaIngreso = LocalDate.of(anioIngreso, mesIngreso, 1);
        
        if(anioRetiro != null && mesRetiro != null) {
            this.fechaRetiro = LocalDate.of(anioRetiro, mesRetiro, 1);
        }
    }

    public String getNombreEmpresa() { return nombreEmpresa; }

    public TipoEmpresa getTipoEmpresa() { return tipoEmpresa; }

    public String getEmail() { return email; }

    public String getTelefono() { return telefono; }

    public String getDireccion() { return direccion; }

    public String getCargoActual() { return cargoActual; }

    public String getDependencia() { return dependencia; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }

    public LocalDate getFechaRetiro() { return fechaRetiro; }

    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) { this.tipoEmpresa = tipoEmpresa; }

    public void setEmail(String email) { this.email = email; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void setCargoActual(String cargoActual) { this.cargoActual = cargoActual; }

    public void setDependencia(String dependencia) { this.dependencia = dependencia; }

    public void setFechaIngreso(int anio, int mes) {
        this.fechaIngreso = LocalDate.of(anio, mes, 1);
    }

    public void setFechaRetiro(int anio, int mes) {
        this.fechaRetiro = LocalDate.of(anio, mes, 1);
    }
    
    public int calcularExperiencia() {
        LocalDate fin = (fechaRetiro != null) ? fechaRetiro : LocalDate.now();
        Period periodo = Period.between(fechaIngreso, fin);
    
        return periodo.getYears() * 12 + periodo.getMonths();
    }
}
