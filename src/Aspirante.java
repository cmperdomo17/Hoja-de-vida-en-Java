public class Aspirante extends Persona {

    private LibretaMilitar libretaMilitar;
    private FormacionAcademica formacionAcademica;
    private ExperienciaLaboral experienciaLaboral;

    public Aspirante(float id, TipoID tipoID, Nacionalidad nacionalidad, Genero sexo, String nombre, String apellido, String direccion, String telefono, String correo, Nacimiento informacionNacimiento, Correspondencia informacionCorrespondencia, LibretaMilitar libretaMilitar, FormacionAcademica formacionAcademica, ExperienciaLaboral experienciaLaboral, ExperienciaOcupacion experienciaOcupacion, Empleo empleo) {
        super(id, tipoID, nacionalidad, sexo, nombre, apellido, direccion, telefono, correo, informacionNacimiento, informacionCorrespondencia, libretaMilitar, formacionAcademica, experienciaLaboral, experienciaOcupacion, empleo);
        this.libretaMilitar = libretaMilitar;
        this.formacionAcademica = formacionAcademica;
        this.experienciaLaboral = experienciaLaboral;
    }

    public LibretaMilitar getLibretaMilitar() { return libretaMilitar; }

    public FormacionAcademica getFormacionAcademica() { return formacionAcademica; }

    public ExperienciaLaboral getExperienciaLaboral() { return experienciaLaboral; }

    public void setLibretaMilitar(LibretaMilitar libretaMilitar) { this.libretaMilitar = libretaMilitar; }

    public void setFormacionAcademica(FormacionAcademica formacionAcademica) { this.formacionAcademica = formacionAcademica; }

    public void setExperienciaLaboral(ExperienciaLaboral experienciaLaboral) { this.experienciaLaboral = experienciaLaboral; }

}
