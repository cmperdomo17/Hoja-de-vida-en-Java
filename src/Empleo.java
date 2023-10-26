import java.util.Calendar;
import java.util.Date;

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
    private Date fechaIngreso;
    private Date fechaRetiro;

    public Empleo(String nombreEmpresa, TipoEmpresa tipoEmpresa, String email, String telefono, String direccion, String cargoActual, String dependencia, Date fechaIngreso, Date fechaRetiro) {
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

    public TipoEmpresa getTipoEmpresa() { return tipoEmpresa; }

    public String getEmail() { return email; }

    public String getTelefono() { return telefono; }

    public String getDireccion() { return direccion; }

    public String getCargoActual() { return cargoActual; }

    public String getDependencia() { return dependencia; }

    public Date getFechaIngreso() { return fechaIngreso; }

    public Date getFechaRetiro() { return fechaRetiro; }

    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) { this.tipoEmpresa = tipoEmpresa; }

    public void setEmail(String email) { this.email = email; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void setCargoActual(String cargoActual) { this.cargoActual = cargoActual; }

    public void setDependencia(String dependencia) { this.dependencia = dependencia; }

    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public void setFechaRetiro(Date fechaRetiro) { this.fechaRetiro = fechaRetiro; }
    
    public int calcularExperiencia() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(fechaIngreso);

        Calendar endCalendar = Calendar.getInstance();

        if (fechaRetiro != null) {
            endCalendar.setTime(fechaRetiro);
        } 

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

        return diffMonth;
    }

    @Override
    public String toString() {
        return "Empleo{" +
                "nombreEmpresa='" + nombreEmpresa + '\'' +
                ", tipoEmpresa=" + tipoEmpresa +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cargoActual='" + cargoActual + '\'' +
                ", dependencia='" + dependencia + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaRetiro=" + fechaRetiro +
                '}';
    }
}
