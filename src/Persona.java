
public class Persona {

    public enum TipoID {
        CC, TI, CE, RC
    }

    public enum Nacionalidad {
        COLOMBIANO, EXTRANJERO
    }

    public enum Genero {
        MASCULINO, FEMENINO
    }

    private float id;
    private TipoID tipoID;
    private Nacionalidad nacionalidad;
    private Genero sexo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private Nacimiento informacionNacimiento;
    private Correspondencia informacionCorrespondencia;
    private LibretaMilitar informacionMilitar;
    private FormacionAcademica formacionAcademica;
    private ExperienciaLaboral experienciaLaboral;
    private ExperienciaOcupacion experienciaOcupacion;
    private Empleo empleo;

    public Persona(float id, TipoID tipoID, Nacionalidad nacionalidad, Genero sexo, String nombre, String apellido, String direccion, String telefono, String correo, Nacimiento informacionNacimiento, Correspondencia informacionCorrespondencia, LibretaMilitar informacionMilitar, FormacionAcademica formacionAcademica, ExperienciaLaboral experienciaLaboral, ExperienciaOcupacion experienciaOcupacion, Empleo empleo) {
        this.id = id;
        this.tipoID = tipoID;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.informacionNacimiento = informacionNacimiento;
        this.informacionCorrespondencia = informacionCorrespondencia;
        this.informacionMilitar = informacionMilitar;
        this.formacionAcademica = formacionAcademica;
        this.experienciaLaboral = experienciaLaboral;
        this.experienciaOcupacion = experienciaOcupacion;
        this.empleo = empleo;
    }

    public float getID() { return id; }

    public TipoID getTipoId() { return tipoID; }

    public Nacionalidad getNacionalidad() { return nacionalidad; }

    public Genero getSexo() { return sexo; }

    public String getNombre() { return nombre; }

    public String getApellido() { return apellido; }

    public String getDireccion() { return direccion; }

    public String getTelefono() { return telefono; }

    public String getCorreo() { return correo; }

    public Nacimiento getInformacionNacimiento() { return informacionNacimiento; }

    public Correspondencia getInformacionCorrespondencia() { return informacionCorrespondencia; }

    public LibretaMilitar getInformacionMilitar() { return informacionMilitar; }

    public FormacionAcademica getFormacionAcademica() { return formacionAcademica; }

    public ExperienciaLaboral getExperienciaLaboral() { return experienciaLaboral; }

    public ExperienciaOcupacion getExperienciaOcupacion() { return experienciaOcupacion; }

    public Empleo getEmpleo() { return empleo; }

    public void setTipoID(String tipoID) {
        try {
            this.tipoID = TipoID.valueOf(tipoID);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de identificación no válido");
        }
    }

    public void setID(int id) {
        if (this.tipoID == null) {
            throw new IllegalStateException("Primero debe configurar un tipoID válido");
        }
        if (id < 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo");
        }
        this.id = id;
    }

    public void setNacionalidad(String nacionalidad) {
        try {
            this.nacionalidad = Nacionalidad.valueOf(nacionalidad);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Nacionalidad no válida");
        }
    }

    public void setSexo(String sexo) {
        try {
            this.sexo = Genero.valueOf(sexo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Sexo no válido");
        }
    }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setInformacionNacimiento(Nacimiento informacionNacimiento) {
        this.informacionNacimiento = informacionNacimiento;
    }

    public void setInformacionCorrespondencia(Correspondencia informacionCorrespondencia) {
        this.informacionCorrespondencia = informacionCorrespondencia;
    }

    public void setInformacionMilitar(LibretaMilitar informacionMilitar) {
        this.informacionMilitar = informacionMilitar;
    }

    public void setFormacionAcademica(FormacionAcademica formacionAcademica) {
        this.formacionAcademica = formacionAcademica;
    }

    public void setExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public void setExperienciaOcupacion(ExperienciaOcupacion experienciaOcupacion) {
        this.experienciaOcupacion = experienciaOcupacion;
    }

    public void setEmpleo(Empleo empleo) {
        this.empleo = empleo;
    }

    // Methods

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", tipoID=" + tipoID +
                ", nacionalidad=" + nacionalidad +
                ", sexo=" + sexo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", informacionNacimiento=" + informacionNacimiento +
                ", informacionCorrespondencia=" + informacionCorrespondencia +
                ", informacionMilitar=" + informacionMilitar +
                ", formacionAcademica=" + formacionAcademica +
                ", experienciaLaboral=" + experienciaLaboral +
                ", experienciaOcupacion=" + experienciaOcupacion +
                ", empleo=" + empleo +
                '}';
    }
}
