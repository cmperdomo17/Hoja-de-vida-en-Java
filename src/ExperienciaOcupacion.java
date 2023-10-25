public class ExperienciaOcupacion implements Experiencia{

    public enum TipoOcupacion {
        SERVIDOR_PUBLICO, EMPLEADO_SECTOR_PRIVADO, TRABAJADOR_INDEPENDIENTE
    }

    private TipoOcupacion tipoOcupacion;
    private int meses;
    private int anios;

    public ExperienciaOcupacion(TipoOcupacion tipoOcupacion, int meses, int anios) {
        this.tipoOcupacion = tipoOcupacion;
        this.meses = meses;
        this.anios = anios;
    }

    public TipoOcupacion getTipoOcupacion() {
        return tipoOcupacion;
    }

    public void setTipoOcupacion(TipoOcupacion tipoOcupacion) {
        this.tipoOcupacion = tipoOcupacion;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        if (meses < 0) {
            throw new IllegalArgumentException("Meses debe ser mayor o igual a 0");
        }
        this.meses = meses;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        if (anios < 0) {
            throw new IllegalArgumentException("Años debe ser mayor o igual a 0");
        }
        this.anios = anios;
    }

    @Override
    public int calcularExperiencia() {
        int mesesTotales = (anios * 12) + meses;
        return mesesTotales;
    }

    @Override
    public String toString() {
        return "ExperienciaOcupacion{" +
                "tipoOcupacion=" + tipoOcupacion +
                ", meses=" + meses +
                ", anios=" + anios +
                '}';
    }
}
