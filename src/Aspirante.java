public class Aspirante extends Persona {
    private LibretaMilitar libretaMilitar;

    public Aspirante() {
    }

    public Aspirante(float id, TipoID tipoID, Nacionalidad nacionalidad, Genero sexo, String nombre, String apellido, String direccion, String telefono, String correo, Nacimiento informacionNacimiento, Correspondencia informacionCorrespondencia, LibretaMilitar libretaMilitar) {
        super(id, tipoID, nacionalidad, sexo, nombre, apellido, direccion, telefono, correo, informacionNacimiento, informacionCorrespondencia);
        this.libretaMilitar = libretaMilitar;
    }    

    public LibretaMilitar getLibretaMilitar() { return libretaMilitar; }

    public void setLibretaMilitar(LibretaMilitar libretaMilitar) { this.libretaMilitar = libretaMilitar; }

}
