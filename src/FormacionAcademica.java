import java.util.List;
import java.util.Date;

public class FormacionAcademica {

    private EducacionBasicayMedia formacionBasicaYMedia;
    private List <EducacionSuperior> formacionSuperior;
    private List <Idioma> formacionIdiomas;

    public FormacionAcademica(EducacionBasicayMedia formacionBasicaYMedia, List<EducacionSuperior> formacionSuperior, List<Idioma> formacionIdiomas) {
        this.formacionBasicaYMedia = formacionBasicaYMedia;
        this.formacionSuperior = formacionSuperior;
        this.formacionIdiomas = formacionIdiomas;
    }

    public EducacionBasicayMedia getFormacionBasicaYMedia() { return formacionBasicaYMedia; }

    public List<EducacionSuperior> getFormacionSuperior() { return formacionSuperior; }

    public List<Idioma> getFormacionIdiomas() { return formacionIdiomas; }

    public void setFormacionBasicaYMedia(EducacionBasicayMedia formacionBasicaYMedia) { this.formacionBasicaYMedia = formacionBasicaYMedia; }   

    public void setFormacionSuperior(List<EducacionSuperior> formacionSuperior) { this.formacionSuperior = formacionSuperior; }

    public void setFormacionIdiomas(List<Idioma> formacionIdiomas) { this.formacionIdiomas = formacionIdiomas; }
    
}

class EducacionSuperior {
    public enum ModalidadAcademica {
        TC, ES, TL, MG, TE, DOC, UN
    }

    private ModalidadAcademica modalidadAcademica;
    private int nSemestresAprobados;
    private boolean graduado;
    private String titulo;
    private Date mesyanioFin;
    private int numTarjetaProfesional;

    public EducacionSuperior(ModalidadAcademica modalidadAcademica, int nSemestresAprobados, boolean graduado, String titulo, Date mesyanioFin, int numTarjetaProfesional) {
        this.modalidadAcademica = modalidadAcademica;
        this.nSemestresAprobados = nSemestresAprobados;
        this.graduado = graduado;
        this.titulo = titulo;
        this.mesyanioFin = mesyanioFin;
        this.numTarjetaProfesional = numTarjetaProfesional;
    }

    public ModalidadAcademica getModalidadAcademica() { return modalidadAcademica; }

    public int getNSemestresAprobados() { return nSemestresAprobados; }

    public boolean isGraduado() { return graduado; }

    public String getTitulo() { return titulo; }

    public Date getMesyanioFin() { return mesyanioFin; }

    public int getNumTarjetaProfesional() { return numTarjetaProfesional; }

    public void setModalidadAcademica(ModalidadAcademica modalidadAcademica) { this.modalidadAcademica = modalidadAcademica; }

    public void setNSemestresAprobados(int nSemestresAprobados) { this.nSemestresAprobados = nSemestresAprobados; }

    public void setGraduado(boolean graduado) { this.graduado = graduado; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setMesyanioFin(Date mesyanioFin) { this.mesyanioFin = mesyanioFin; }

    public void setNumTarjetaProfesional(int numTarjetaProfesional) { this.numTarjetaProfesional = numTarjetaProfesional; }

}

class Idioma {
    public enum NivelIdioma {
        R, B, MB
    }

    private NivelIdioma habla;
    private NivelIdioma lee;
    private NivelIdioma escribe;

    public Idioma(NivelIdioma habla, NivelIdioma lee, NivelIdioma escribe) {
        this.habla = habla;
        this.lee = lee;
        this.escribe = escribe;
    }

    public NivelIdioma getHabla() { return habla; }

    public NivelIdioma getLee() { return lee; }

    public NivelIdioma getEscribe() { return escribe; }

    public void setHabla(NivelIdioma habla) { this.habla = habla; }

    public void setLee(NivelIdioma lee) { this.lee = lee; }

}
class EducacionBasicayMedia {
    private List <Integer> institucion; 
    private String titulo;
    private Date fechaGrado;

    public EducacionBasicayMedia(List<Integer> institucion, String titulo, Date fechaGrado) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.fechaGrado = fechaGrado;
    }

    public List<Integer> getInstitucion() { return institucion; }

    public String getTitulo() { return titulo; }

    public Date getFechaGrado() { return fechaGrado; }

    public void setInstitucion(List<Integer> institucion) { this.institucion = institucion; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setFechaGrado(Date fechaGrado) { this.fechaGrado = fechaGrado; }

}
