import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.Normalizer.Form;
import java.util.Arrays;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Guardar información");
            System.out.println("2. Leer información");
            System.out.println("3. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // TODO
                    break;
                case 2:
                    Persona persona = leerInfo();
                    ImprimirInfo(persona);
                    break;
                case 3:
                System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("\nOpción inválida");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }

    public static Persona leerInfo(){
        String file = "src/persona.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            float id = Float.parseFloat(reader.readLine());
            Persona.TipoID tipoId = Persona.TipoID.valueOf(reader.readLine());
            Persona.Nacionalidad nacionalidad = Persona.Nacionalidad.valueOf(reader.readLine());
            Persona.Genero sexo = Persona.Genero.valueOf(reader.readLine());
            String nombre = reader.readLine();
            String apellido = reader.readLine();
            String direccion = reader.readLine();
            String telefono = reader.readLine();
            String correo = reader.readLine();
            String paisNacimiento = reader.readLine();
            String departamentoNacimiento = reader.readLine();
            String municipioNacimiento = reader.readLine();
            String fechaStr = reader.readLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNacimiento = null;
            try {
                fechaNacimiento = sdf.parse(fechaStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
            }
            String paisCorrespondencia = reader.readLine();
            String departamentoCorrespondencia = reader.readLine();
            String municipioCorrespondencia = reader.readLine();
            String direccionCorrespondencia = reader.readLine();
            String email = reader.readLine();
            String telefonoCorrespondencia = reader.readLine();
            LibretaMilitar.TipoLibreta tipoLibreta = LibretaMilitar.TipoLibreta.valueOf(reader.readLine());
            int numeroLibreta = Integer.parseInt(reader.readLine());
            int DM = Integer.parseInt(reader.readLine());
            // Educacion Basica y Media
            int gradosCursados = Integer.parseInt(reader.readLine());
            String titulo = reader.readLine();
            Date fechaGrado = null;
            try {
                fechaGrado = sdf.parse(reader.readLine());
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
            }
            EducacionBasicayMedia formacionBasicaYMedia = new EducacionBasicayMedia(Arrays.asList(gradosCursados), titulo, fechaGrado);
            // Educacion Superior
            EducacionSuperior.ModalidadAcademica modalidadAcademica = EducacionSuperior.ModalidadAcademica.valueOf(reader.readLine());
            int nSemestresAprobados = Integer.parseInt(reader.readLine());
            boolean graduado = Boolean.parseBoolean(reader.readLine());
            String tituloSuperior = reader.readLine();
            Date mesyanioFin = null;
            try {
                mesyanioFin = sdf.parse(reader.readLine());
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
            }
            int numTarjetaProfesional = Integer.parseInt(reader.readLine());
            EducacionSuperior formacionSuperior = new EducacionSuperior(modalidadAcademica, nSemestresAprobados, graduado, tituloSuperior, mesyanioFin, numTarjetaProfesional);
            // Idiomas
            Idioma.NivelIdioma habla = Idioma.NivelIdioma.valueOf(reader.readLine());
            Idioma.NivelIdioma lee = Idioma.NivelIdioma.valueOf(reader.readLine());
            Idioma.NivelIdioma escribe = Idioma.NivelIdioma.valueOf(reader.readLine());
            Idioma idioma = new Idioma(habla, lee, escribe);
            // Empleo
            String nombreEmpresa = reader.readLine();
            Empleo.TipoEmpresa tipoEmpresa = Empleo.TipoEmpresa.valueOf(reader.readLine());
            String EmpleoEmail = reader.readLine();
            String EmpleoTelefono = reader.readLine();
            String EmpleoDireccion = reader.readLine();
            String cargoActual = reader.readLine();
            String dependencia = reader.readLine();
            Date fechaIngreso = null;
            try {
                fechaIngreso = sdf.parse(reader.readLine());
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
            }
            Date fechaRetiro = null;
            try {
                fechaRetiro = sdf.parse(reader.readLine());
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
            }
 
            Nacimiento informacionNacimiento = new Nacimiento(paisNacimiento, departamentoNacimiento, municipioNacimiento, fechaNacimiento);
            Correspondencia informacionCorrespondencia = new Correspondencia(paisCorrespondencia, departamentoCorrespondencia, municipioCorrespondencia, direccionCorrespondencia, email, telefonoCorrespondencia);
            LibretaMilitar informacionMilitar = new LibretaMilitar(tipoLibreta, numeroLibreta, DM);
            FormacionAcademica formacionAcademica = new FormacionAcademica(formacionBasicaYMedia, Arrays.asList(formacionSuperior), Arrays.asList(idioma));
            Empleo empleo = new Empleo(nombreEmpresa, tipoEmpresa, EmpleoEmail, EmpleoTelefono, EmpleoDireccion, cargoActual, dependencia, fechaIngreso, fechaRetiro);
            
            return new Persona(id, tipoId, nacionalidad, sexo, nombre, apellido, direccion, telefono, correo, informacionNacimiento, informacionCorrespondencia, informacionMilitar, formacionAcademica, null, null, empleo);
        } catch (IOException e) {
            System.out.println("Error al leer");
            return null;
        }
    }

    public static void guardarInfo(Persona persona){

        String file = "HojaDeVida.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write(persona.getID() + "\n");
        writer.write(persona.getTipoId().toString() + "\n");
        writer.write(persona.getNacionalidad().toString() + "\n");
        writer.write(persona.getSexo().toString() + "\n");
        writer.write(persona.getNombre() + "\n");
        writer.write(persona.getApellido() + "\n");
        writer.write(persona.getDireccion() + "\n");
        writer.write(persona.getTelefono() + "\n");
        writer.write(persona.getCorreo() + "\n");
        writer.write(persona.getInformacionNacimiento().getPais() + "\n");
        writer.write(persona.getInformacionNacimiento().getDepartamento() + "\n");
        writer.write(persona.getInformacionNacimiento().getMunicipio() + "\n");
        writer.write(persona.getInformacionNacimiento().getFecha() + "\n");
        writer.write(persona.getInformacionCorrespondencia().getPais() + "\n");
        writer.write(persona.getInformacionCorrespondencia().getDepartamento() + "\n");
        writer.write(persona.getInformacionCorrespondencia().getMunicipio() + "\n");
        writer.write(persona.getInformacionCorrespondencia().getDireccion() + "\n");
        writer.write(persona.getInformacionCorrespondencia().getEmail() + "\n");
        writer.write(persona.getInformacionCorrespondencia().getTelefono() + "\n");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        writer.write(sdf.format(persona.getInformacionNacimiento().getFecha()) + "\n");
        writer.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }

    }

    public static void ImprimirInfo(Persona persona){
        System.out.println("\nInformación Hoja de Vida:");
        System.out.println("\nNumero de identificacion: " + persona.getID());
        System.out.println("\nTipo de identificacion: " + persona.getTipoId());
        System.out.println("\nNacionalidad: " + persona.getNacionalidad());
        System.out.println("\nGenero: " + persona.getSexo());
        System.out.println("\nNombre: " + persona.getNombre());
        System.out.println("\nApellido: " + persona.getApellido());
        System.out.println("\nDireccion: " + persona.getDireccion());
        System.out.println("\nTelefono: " + persona.getTelefono());
        System.out.println("\nCorreo: " + persona.getCorreo());
        System.out.println("\nPais de nacimiento: " + persona.getInformacionNacimiento().getPais());
        System.out.println("\nDepartamento de nacimiento: " + persona.getInformacionNacimiento().getDepartamento());
        System.out.println("\nMunicipio de nacimiento: " + persona.getInformacionNacimiento().getMunicipio());
        System.out.println("\nFecha de nacimiento: " + persona.getInformacionNacimiento().getFecha());
        System.out.println("\nPais de correspondencia: " + persona.getInformacionCorrespondencia().getPais());
        System.out.println("\nDepartamento de correspondencia: " + persona.getInformacionCorrespondencia().getDepartamento());
        System.out.println("\nMunicipio de correspondencia: " + persona.getInformacionCorrespondencia().getMunicipio());
        System.out.println("\nDireccion de correspondencia: " + persona.getInformacionCorrespondencia().getDireccion());
        System.out.println("\nEmail de correspondencia: " + persona.getInformacionCorrespondencia().getEmail());
        System.out.println("\nTelefono de correspondencia: " + persona.getInformacionCorrespondencia().getTelefono());
        System.out.println("\nTipo Libreta Militar: " + persona.getInformacionMilitar().getTipoLibreta());
        System.out.println("\nNumero Libreta Militar: " + persona.getInformacionMilitar().getNumeroLibreta());
        System.out.println("\nDistrito Militar: " + persona.getInformacionMilitar().getDM());
        System.out.println("\nGrados Cursados: " + persona.getFormacionAcademica().getFormacionBasicaYMedia().getgradosCursados());
        System.out.println("\nTitulo: " + persona.getFormacionAcademica().getFormacionBasicaYMedia().getTitulo());
        System.out.println("\nFecha de Grado: " + persona.getFormacionAcademica().getFormacionBasicaYMedia().getFechaGrado());
        System.out.println("\nModalidad Academica: " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getModalidadAcademica());
        System.out.println("\nSemestres Aprobados: " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getNSemestresAprobados());
        System.out.println("\nGraduado: " + persona.getFormacionAcademica().getFormacionSuperior().get(0).isGraduado());
        System.out.println("\nTitulo Superior: " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getTitulo());
        System.out.println("\nMes y Año de Finalizacion: " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getMesyanioFin());
        System.out.println("\nNumero de Tarjeta Profesional: " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getNumTarjetaProfesional());
        System.out.println("\nHabla: " + persona.getFormacionAcademica().getFormacionIdiomas().get(0).getHabla());
        System.out.println("\nLee: " + persona.getFormacionAcademica().getFormacionIdiomas().get(0).getLee());
        System.out.println("\nEscribe: " + persona.getFormacionAcademica().getFormacionIdiomas().get(0).getEscribe());
        System.out.println("\nNombre Empresa: " + persona.getEmpleo().getNombreEmpresa());
        System.out.println("\nTipo Empresa: " + persona.getEmpleo().getTipoEmpresa());
        System.out.println("\nEmail Empresa: " + persona.getEmpleo().getEmail());
        System.out.println("\nTelefono Empresa: " + persona.getEmpleo().getTelefono());
        System.out.println("\nDireccion Empresa: " + persona.getEmpleo().getDireccion());
        System.out.println("\nCargo Actual: " + persona.getEmpleo().getCargoActual());
        System.out.println("\nDependencia: " + persona.getEmpleo().getDependencia());
        System.out.println("\nFecha de Ingreso: " + persona.getEmpleo().getFechaIngreso());
        System.out.println("\nFecha de Retiro: " + persona.getEmpleo().getFechaRetiro());
        
    }
}
