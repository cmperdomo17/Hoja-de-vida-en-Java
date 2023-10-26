import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        List<Persona> listaPersonas = new ArrayList<>();
        
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Guardar información");
            System.out.println("2. Leer información");
            System.out.println("3. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine();

            Persona persona = null;
            switch (opcion) {
                case 1:               
                    Persona nuevaPersona = guardarInfo();  // asumo que guardarInfo devuelve una nueva Persona creada
                    listaPersonas.add(nuevaPersona);
                    break;
                case 2:
                    persona = leerInfo();
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

            // Experiencia Ocupacion
            ExperienciaOcupacion.TipoOcupacion tipoOcupacion = ExperienciaOcupacion.TipoOcupacion.valueOf(reader.readLine());
            int meses = Integer.parseInt(reader.readLine());
            int anios = Integer.parseInt(reader.readLine());
            ExperienciaOcupacion experienciaOcupacion = new ExperienciaOcupacion(tipoOcupacion, meses, anios);

            // Experiencia Laboral
            Empleo empleoActual = new Empleo(nombreEmpresa, tipoEmpresa, EmpleoEmail, EmpleoTelefono, EmpleoDireccion, cargoActual, dependencia, fechaIngreso, fechaRetiro);
            Empleo empleoAnterior = new Empleo(nombreEmpresa, tipoEmpresa, EmpleoEmail, EmpleoTelefono, EmpleoDireccion, cargoActual, dependencia, fechaIngreso, fechaRetiro);
            String totalTiempoExperiencia = reader.readLine();
            
            Nacimiento informacionNacimiento = new Nacimiento(paisNacimiento, departamentoNacimiento, municipioNacimiento, fechaNacimiento);
            Correspondencia informacionCorrespondencia = new Correspondencia(paisCorrespondencia, departamentoCorrespondencia, municipioCorrespondencia, direccionCorrespondencia, email, telefonoCorrespondencia);
            LibretaMilitar informacionMilitar = new LibretaMilitar(tipoLibreta, numeroLibreta, DM);
            FormacionAcademica formacionAcademica = new FormacionAcademica(formacionBasicaYMedia, Arrays.asList(formacionSuperior), Arrays.asList(idioma));
            Empleo empleo = new Empleo(nombreEmpresa, tipoEmpresa, EmpleoEmail, EmpleoTelefono, EmpleoDireccion, cargoActual, dependencia, fechaIngreso, fechaRetiro);
            ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(empleoActual, Arrays.asList(empleoAnterior), Arrays.asList(experienciaOcupacion), totalTiempoExperiencia);
            

            return new Persona(id, tipoId, nacionalidad, sexo, nombre, apellido, direccion, telefono, correo, informacionNacimiento, informacionCorrespondencia, informacionMilitar, formacionAcademica, experienciaLaboral, experienciaOcupacion, empleo);
        } catch (IOException e) {
            System.out.println("Error al leer");
            return null;
        }
    }

    public static Persona guardarInfo(){

        String baseFilename = "persona.txt";
        String file = baseFilename;
        int index = 1;
        
        while(Files.exists(Paths.get(file))) {
            file = "persona" + index + ".txt";
            index++;
        }
    
        // Solicitar al usuario la información de la persona
        Scanner sc = new Scanner(System.in);

        // Información Personal
        System.out.println("\nInformación Personal:");
        System.out.print("ID: ");
        float id = sc.nextFloat();
        sc.nextLine();
        System.out.print("Tipo ID: ");
        String tipoIdStr = sc.nextLine();
        Persona.TipoID tipoId = null;
        try {
            tipoId = Persona.TipoID.valueOf(tipoIdStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de identificación no válido");
        }
        System.out.print("Nacionalidad: ");
        String nacionalidadStr = sc.nextLine();
        Persona.Nacionalidad nacionalidad = null;
        try {
            nacionalidad = Persona.Nacionalidad.valueOf(nacionalidadStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Nacionalidad no válida");
        }
        System.out.print("Género: ");
        String sexoStr = sc.nextLine();
        Persona.Genero sexo = null;
        try {
            sexo = Persona.Genero.valueOf(sexoStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Género no válido");
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        // Información de Nacimiento
        System.out.println("\nInformación de Nacimiento:");
        System.out.print("País: ");
        String paisNacimiento = sc.nextLine();
        System.out.print("Departamento: ");
        String departamentoNacimiento = sc.nextLine();
        System.out.print("Municipio: ");
        String municipioNacimiento = sc.nextLine();
        System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = sdf.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
        }
        Nacimiento informacionNacimiento = new Nacimiento(paisNacimiento, departamentoNacimiento, municipioNacimiento, fechaNacimiento);

        // Información de Correspondencia
        System.out.println("\nInformación de Correspondencia:");
        System.out.print("País: ");
        String paisCorrespondencia = sc.nextLine();
        System.out.print("Departamento: ");
        String departamentoCorrespondencia = sc.nextLine();
        System.out.print("Municipio: ");
        String municipioCorrespondencia = sc.nextLine();
        System.out.print("Dirección: ");
        String direccionCorrespondencia = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefonoCorrespondencia = sc.nextLine();

        Correspondencia informacionCorrespondencia = new Correspondencia(paisCorrespondencia, departamentoCorrespondencia, municipioCorrespondencia, direccionCorrespondencia, email, telefonoCorrespondencia);

        // Información Militar
        System.out.println("\nInformación Militar:");
        System.out.print("Tipo Libreta: ");
        String tipoLibretaStr = sc.nextLine();
        LibretaMilitar.TipoLibreta tipoLibreta = null;
        try {
            tipoLibreta = LibretaMilitar.TipoLibreta.valueOf(tipoLibretaStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de libreta no válido");
        }
        System.out.print("Número Libreta: ");
        int numeroLibreta = sc.nextInt();
        System.out.print("Distrito Militar: ");
        int DM = sc.nextInt();
        LibretaMilitar informacionMilitar = new LibretaMilitar(tipoLibreta, numeroLibreta, DM);

        // Formación Académica
        System.out.println("\nFormación Académica:");
        System.out.println("Educación Básica y Media:");
        System.out.print("Grados Cursados: ");
        int gradosCursados = sc.nextInt();
        sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Fecha de Grado (dd/MM/yyyy): ");
        String fechaGradoStr = sc.nextLine();
        Date fechaGrado = null;
        try {
            fechaGrado = sdf.parse(fechaGradoStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
        }
        EducacionBasicayMedia formacionBasicaYMedia = new EducacionBasicayMedia(Arrays.asList(gradosCursados), titulo, fechaGrado);

        System.out.println("Educación Superior:");
        System.out.print("Modalidad Académica: ");
        String modalidadAcademicaStr = sc.nextLine();
        EducacionSuperior.ModalidadAcademica modalidadAcademica = null;
        try {
            modalidadAcademica = EducacionSuperior.ModalidadAcademica.valueOf(modalidadAcademicaStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Modalidad académica no válida");
        }
        System.out.print("Semestres Aprobados: ");
        int nSemestresAprobados = sc.nextInt();
        sc.nextLine();
        System.out.print("Graduado (true/false): ");
        boolean graduado = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Título Superior: ");
        String tituloSuperior = sc.nextLine();
        System.out.print("Mes y Año de Finalización (dd/MM/yyyy): ");

        String mesyanioFinStr = sc.nextLine();
        Date mesyanioFin = null;

        try {
            mesyanioFin = sdf.parse(mesyanioFinStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
        }

        System.out.print("Número de Tarjeta Profesional: ");

        int numTarjetaProfesional = sc.nextInt();

        EducacionSuperior formacionSuperior = new EducacionSuperior(modalidadAcademica, nSemestresAprobados, graduado, tituloSuperior, mesyanioFin, numTarjetaProfesional);

        // Idiomas
        System.out.println("Idiomas:");
        System.out.print("Habla: ");
        String hablaStr = sc.nextLine();
        Idioma.NivelIdioma habla = null;
        try {
            habla = Idioma.NivelIdioma.valueOf(hablaStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Nivel de idioma no válido");
        }
        System.out.print("Lee: ");
        String leeStr = sc.nextLine();
        Idioma.NivelIdioma lee = null;
        try {
            lee = Idioma.NivelIdioma.valueOf(leeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Nivel de idioma no válido");
        }
        System.out.print("Escribe: ");
        String escribeStr = sc.nextLine();
        Idioma.NivelIdioma escribe = null;
        try {
            escribe = Idioma.NivelIdioma.valueOf(escribeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Nivel de idioma no válido");
        }
        Idioma idioma = new Idioma(habla, lee, escribe);

        FormacionAcademica formacionAcademica = new FormacionAcademica(formacionBasicaYMedia, Arrays.asList(formacionSuperior), Arrays.asList(idioma));

        // Experiencia Ocupacion
        System.out.println("Experiencia Ocupación:");
        System.out.print("Tipo Ocupación: ");
        String tipoOcupacionStr = sc.nextLine();
        ExperienciaOcupacion.TipoOcupacion tipoOcupacion = null;
        try {
            tipoOcupacion = ExperienciaOcupacion.TipoOcupacion.valueOf(tipoOcupacionStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de ocupación no válido");
        }
        System.out.print("Meses: ");
        int meses = sc.nextInt();
        System.out.print("Años: ");
        int anios = sc.nextInt();
        ExperienciaOcupacion experienciaOcupacion = new ExperienciaOcupacion(tipoOcupacion, meses, anios);

        // Experiencia Laboral
        System.out.println("Experiencia Laboral:");
        System.out.println("Empleo Actual:");
        System.out.print("Nombre Empresa: ");
        sc.nextLine();
        String nombreEmpresa = sc.nextLine();
        System.out.print("Tipo Empresa: ");
        String tipoEmpresaStr = sc.nextLine();
        Empleo.TipoEmpresa tipoEmpresa = null;
        try {
            tipoEmpresa = Empleo.TipoEmpresa.valueOf(tipoEmpresaStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de empresa no válido");
        }
        System.out.print("Email: ");
        String EmpleoEmail = sc.nextLine();
        System.out.print("Teléfono: ");
        String EmpleoTelefono = sc.nextLine();
        System.out.print("Dirección: ");
        String EmpleoDireccion = sc.nextLine();
        System.out.print("Cargo Actual: ");
        String cargoActual = sc.nextLine();
        System.out.print("Dependencia: ");
        String dependencia = sc.nextLine();
        System.out.print("Fecha de Ingreso (dd/MM/yyyy): ");
        String fechaIngresoStr = sc.nextLine();
        Date fechaIngreso = null;
        try {
            fechaIngreso = sdf.parse(fechaIngresoStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
        }
        System.out.print("Fecha de Retiro (dd/MM/yyyy): ");
        String fechaRetiroStr = sc.nextLine();
        Date fechaRetiro = null;
        try {
            fechaRetiro = sdf.parse(fechaRetiroStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
        }
        
        Empleo empleoActual = new Empleo(nombreEmpresa, tipoEmpresa, EmpleoEmail, EmpleoTelefono, EmpleoDireccion, cargoActual, dependencia, fechaIngreso, fechaRetiro);

        System.out.println("Empleo Anterior:");
        System.out.print("Nombre Empresa: ");
        String nombreEmpresaAnterior = sc.nextLine();
        System.out.print("Tipo Empresa: ");
        String tipoEmpresaAnteriorStr = sc.nextLine();
        Empleo.TipoEmpresa tipoEmpresaAnterior = null;
        try {
            tipoEmpresaAnterior = Empleo.TipoEmpresa.valueOf(tipoEmpresaAnteriorStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de empresa no válido");
        }
        System.out.print("Email: ");
        String EmpleoEmailAnterior = sc.nextLine();
        System.out.print("Teléfono: ");
        String EmpleoTelefonoAnterior = sc.nextLine();
        System.out.print("Dirección: ");
        String EmpleoDireccionAnterior = sc.nextLine();
        System.out.print("Cargo Actual: ");
        String cargoActualAnterior = sc.nextLine();
        System.out.print("Dependencia: ");
        String dependenciaAnterior = sc.nextLine();
        System.out.print("Fecha de Ingreso (dd/MM/yyyy): ");
        String fechaIngresoAnteriorStr = sc.nextLine();
        Date fechaIngresoAnterior = null;
        try {
            fechaIngresoAnterior = sdf.parse(fechaIngresoAnteriorStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
        }
        System.out.print("Fecha de Retiro (dd/MM/yyyy): ");
        String fechaRetiroAnteriorStr = sc.nextLine();
        Date fechaRetiroAnterior = null;

        try {
            fechaRetiroAnterior = sdf.parse(fechaRetiroAnteriorStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
        }

        Empleo empleoAnterior = new Empleo(nombreEmpresaAnterior, tipoEmpresaAnterior, EmpleoEmailAnterior, EmpleoTelefonoAnterior, EmpleoDireccionAnterior, cargoActualAnterior, dependenciaAnterior, fechaIngresoAnterior, fechaRetiroAnterior);

        System.out.print("Total Tiempo Experiencia: ");
        String totalTiempoExperiencia = sc.nextLine();

        Empleo empleo = new Empleo(nombreEmpresa, tipoEmpresa, EmpleoEmail, EmpleoTelefono, EmpleoDireccion, cargoActual, dependencia, fechaIngreso, fechaRetiro);

        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(empleoActual, Arrays.asList(empleoAnterior), Arrays.asList(experienciaOcupacion), totalTiempoExperiencia);

        Persona persona = new Persona(id, tipoId, nacionalidad, sexo, nombre, apellido, direccion, telefono, correo, informacionNacimiento, informacionCorrespondencia, informacionMilitar, formacionAcademica, experienciaLaboral, experienciaOcupacion, empleo);

        sc.close();

        return persona;

    }

    public static void ImprimirInfo(Persona persona){
        // Información Personal
        System.out.println("\nInformación Hoja de Vida:");
        System.out.println("| Propiedad | Valor |");
        System.out.println("|------------------------|");
        System.out.println("| ID | " + persona.getID() + " |");
        System.out.println("| Tipo ID | " + persona.getTipoId() + " |");
        System.out.println("| Nacionalidad | " + persona.getNacionalidad() + " |");
        System.out.println("| Género | " + persona.getSexo() + " |");
        System.out.println("| Nombre | " + persona.getNombre() + " |");
        System.out.println("| Apellido | " + persona.getApellido() + " |");
        System.out.println("| Dirección | " + persona.getDireccion() + " |");
        System.out.println("| Teléfono | " + persona.getTelefono() + " |");
        System.out.println("| Correo | " + persona.getCorreo() + " |");

        // Información de Nacimiento
        System.out.println("\nInformación de Nacimiento:");
        System.out.println("| Propiedad | Valor |");
        System.out.println("|------------------------|");
        System.out.println("| País | " + persona.getInformacionNacimiento().getPais() + " |");
        System.out.println("| Departamento | " + persona.getInformacionNacimiento().getDepartamento() + " |");
        System.out.println("| Municipio | " + persona.getInformacionNacimiento().getMunicipio() + " |");
        System.out.println("| Fecha | " + persona.getInformacionNacimiento().getFecha() + " |");

        // Información de Correspondencia
        System.out.println("\nInformación de Correspondencia:");
        System.out.println("| Propiedad | Valor |");
        System.out.println("|------------------------|");
        System.out.println("| País | " + persona.getInformacionCorrespondencia().getPais() + " |");
        System.out.println("| Departamento | " + persona.getInformacionCorrespondencia().getDepartamento() + " |");
        System.out.println("| Municipio | " + persona.getInformacionCorrespondencia().getMunicipio() + " |");
        System.out.println("| Dirección | " + persona.getInformacionCorrespondencia().getDireccion() + " |");
        System.out.println("| Email | " + persona.getInformacionCorrespondencia().getEmail() + " |");
        System.out.println("| Teléfono | " + persona.getInformacionCorrespondencia().getTelefono() + " |");

        // Información Militar
        System.out.println("\nInformación Militar:");
        System.out.println("| Propiedad | Valor |");
        System.out.println("|------------------------|");
        System.out.println("| Tipo Libreta | " + persona.getInformacionMilitar().getTipoLibreta() + " |");
        System.out.println("| Número Libreta | " + persona.getInformacionMilitar().getNumeroLibreta() + " |");
        System.out.println("| Distrito Militar | " + persona.getInformacionMilitar().getDM() + " |");

        // Formación Académica
        System.out.println("\nFormación Académica:");
        System.out.println("| Propiedad | Valor |");
        System.out.println("|------------------------|");
        System.out.println("| Grados Cursados | " + persona.getFormacionAcademica().getFormacionBasicaYMedia().getgradosCursados() + " |");
        System.out.println("| Título | " + persona.getFormacionAcademica().getFormacionBasicaYMedia().getTitulo() + " |");
        System.out.println("| Fecha de Grado | " + persona.getFormacionAcademica().getFormacionBasicaYMedia().getFechaGrado() + " |");
        System.out.println("| Modalidad Académica | " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getModalidadAcademica() + " |");
        System.out.println("| Semestres Aprobados | " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getNSemestresAprobados() + " |");
        System.out.println("| Graduado | " + persona.getFormacionAcademica().getFormacionSuperior().get(0).isGraduado() + " |");
        System.out.println("| Título Superior | " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getTitulo() + " |");
        System.out.println("| Mes y Año de Finalización | " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getMesyanioFin() + " |");
        System.out.println("| Número de Tarjeta Profesional | " + persona.getFormacionAcademica().getFormacionSuperior().get(0).getNumTarjetaProfesional() + " |");
        System.out.println("| Habla | " + persona.getFormacionAcademica().getFormacionIdiomas().get(0).getHabla() + " |");
        System.out.println("| Lee | " + persona.getFormacionAcademica().getFormacionIdiomas().get(0).getLee() + " |");
        System.out.println("| Escribe | " + persona.getFormacionAcademica().getFormacionIdiomas().get(0).getEscribe() + " |");

        // Empleo
        System.out.println("\nEmpleo:");
        System.out.println("| Propiedad | Valor |");
        System.out.println("|------------------------|");
        System.out.println("| Nombre Empresa | " + persona.getEmpleo().getNombreEmpresa() + " |");
        System.out.println("| Tipo Empresa | " + persona.getEmpleo().getTipoEmpresa() + " |");
        System.out.println("| Email Empresa | " + persona.getEmpleo().getEmail() + " |");
        System.out.println("| Teléfono Empresa | " + persona.getEmpleo().getTelefono() + " |");
        System.out.println("| Dirección Empresa | " + persona.getEmpleo().getDireccion() + " |");
        System.out.println("| Cargo Actual | " + persona.getEmpleo().getCargoActual() + " |");
        System.out.println("| Dependencia | " + persona.getEmpleo().getDependencia() + " |");
        System.out.println("| Fecha de Ingreso | " + persona.getEmpleo().getFechaIngreso() + " |");
        System.out.println("| Fecha de Retiro | " + persona.getEmpleo().getFechaRetiro() + " |");

        // Experiencia Laboral
        System.out.println("\nExperiencia Laboral:");
        System.out.println("| Propiedad | Valor |");
        System.out.println("|------------------------|");
        System.out.println("| Tipo de Ocupación | " + persona.getExperienciaLaboral().getExperienciaOcupacion().get(0).getTipoOcupacion() + " |");
        System.out.println("| Meses | " + persona.getExperienciaLaboral().getExperienciaOcupacion().get(0).getMeses() + " |");
        System.out.println("| Años | " + persona.getExperienciaLaboral().getExperienciaOcupacion().get(0).getAnios() + " |");
        System.out.println("| Empleo Actual | " + persona.getExperienciaLaboral().getEmpleoActual().getCargoActual() + " |");
        System.out.println("| Empleos Anteriores |");
        List<Empleo> empleosAnteriores = persona.getExperienciaLaboral().getEmpleoAnterior();
        for (Empleo empleo : empleosAnteriores) {
            System.out.println("| " + empleo.getCargoActual() + " |");
        }

        List<ExperienciaOcupacion> experienciasOcupacion = persona.getExperienciaLaboral().getExperienciaOcupacion();

        System.out.println("| Experiencias en Ocupación |");
        for (ExperienciaOcupacion experiencia : experienciasOcupacion) {
            System.out.println("| " + experiencia.getTipoOcupacion() + ": " + experiencia.calcularExperiencia() + " meses |");
        }

        System.out.println("| Total Tiempo Experiencia | " + persona.getExperienciaLaboral().getTotalTiempoExperiencia() + " |");
    }
}
