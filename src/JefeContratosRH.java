import java.util.Date;

public class JefeContratosRH extends Persona implements Firma{
    
    private String firma;

    public JefeContratosRH(float id, TipoID tipoID, Nacionalidad nacionalidad, Genero sexo, String nombre, String apellido, String direccion, String telefono, String correo, Nacimiento informacionNacimiento, Correspondencia informacionCorrespondencia, LibretaMilitar libretaMilitar, FormacionAcademica formacionAcademica, ExperienciaLaboral experienciaLaboral, ExperienciaOcupacion experienciaOcupacion, Empleo empleo) {
        super(id, tipoID, nacionalidad, sexo, nombre, apellido, direccion, telefono, correo, informacionNacimiento, informacionCorrespondencia, libretaMilitar, formacionAcademica, experienciaLaboral, experienciaOcupacion, empleo);
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Override
    public String firmar() {
        return firma;
    }

    @Override
    public void obtenerFechaFirma() {
        Date fechaActual = new Date();
        System.out.println("Fecha de firma: " + fechaActual);
    }

    @Override
    public String toString() {
        return "Jefe Contratos/RH{" + "firma=" + firma + '}';
    }

}
