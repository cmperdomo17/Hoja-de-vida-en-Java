// ! Nota: Revisar la validación de los setters
// TODO: Implementar la validación de los setters
// TODO: Implementar los métodos

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

    public Persona() {
    }
    public Persona(float id, TipoID tipoID, Nacionalidad nacionalidad, Genero sexo, String nombre, String apellido, String direccion, String telefono, String correo, Nacimiento informacionNacimiento, Correspondencia informacionCorrespondencia) {
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

    // Methods

}
