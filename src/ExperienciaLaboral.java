import java.util.List;

public class ExperienciaLaboral implements Experiencia{
    private Empleo empleoActual;
    private List<Empleo> empleoAnterior;
    private List<ExperienciaOcupacion> experienciaOcupacion;
    private String totalTiempoExperiencia;

    public ExperienciaLaboral(Empleo empleoActual, List<Empleo> empleoAnterior, List<ExperienciaOcupacion> experienciaOcupacion, String totalTiempoExperiencia) {
        this.empleoActual = empleoActual;
        this.empleoAnterior = empleoAnterior;
        this.experienciaOcupacion = experienciaOcupacion;
        this.totalTiempoExperiencia = totalTiempoExperiencia;
    }

    public Empleo getEmpleoActual() { return empleoActual; }

    public List<Empleo> getEmpleoAnterior() { return empleoAnterior; }

    public List<ExperienciaOcupacion> getExperienciaOcupacion() { return experienciaOcupacion; }

    public String getTotalTiempoExperiencia() { return totalTiempoExperiencia; }

    public void setEmpleoActual(Empleo empleoActual) { this.empleoActual = empleoActual; }

    public void setEmpleoAnterior(List<Empleo> empleoAnterior) { this.empleoAnterior = empleoAnterior; }

    public void setExperienciaOcupacion(List<ExperienciaOcupacion> experienciaOcupacion) { this.experienciaOcupacion = experienciaOcupacion; }

    public void setTotalTiempoExperiencia(String totalTiempoExperiencia) { this.totalTiempoExperiencia = totalTiempoExperiencia; }

    @Override
    public int calcularExperiencia() {
        
        int mesesTotales = 0;
    
        if(empleoActual != null) {
            mesesTotales += empleoActual.calcularExperiencia();
        }
    
        for (Empleo e : empleoAnterior) {
            mesesTotales += e.calcularExperiencia();
        }
    
        return mesesTotales;
    }
}
