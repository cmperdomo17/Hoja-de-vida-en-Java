// import java.util.Scanner;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// public class Main {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Pedir los atributos del constructor Persona en su orden

//         System.out.println("Ingrese su numero de identificacion: ");
//         float numeroIdentificacion = Float.parseFloat(sc.nextLine());

//         System.out.println("Ingrese su tipo de identificacion: ");
//         Persona.TipoID tipoIdentificacion = Persona.TipoID.valueOf(sc.nextLine().toUpperCase());

//         System.out.println("Ingrese su Nacionalidad: ");
//         Persona.Nacionalidad nacionalidad = Persona.Nacionalidad.valueOf(sc.nextLine().toUpperCase());

//         System.out.println("Ingrese su genero: ");
//         Persona.Genero genero = Persona.Genero.valueOf(sc.nextLine().toUpperCase());

//         System.out.println("Ingrese su nombre: ");
//         String nombre = sc.nextLine();

//         System.out.println("Ingrese su apellido: ");
//         String apellido = sc.nextLine();

//         System.out.println("Ingrese su direccion: ");
//         String direccion = sc.nextLine();

//         System.out.println("Ingrese su telefono: ");
//         String telefono = sc.nextLine();

//         System.out.println("Ingrese su correo: ");
//         String correo = sc.nextLine();


//         System.out.println("Ingrese su pais de nacimiento: ");
//         String paisNacimiento = sc.nextLine();

//         System.out.println("Ingrese su departamento de nacimiento: ");
//         String departamentoNacimiento = sc.nextLine();

//         System.out.println("Ingrese su municipio de nacimiento: ");
//         String municipioNacimiento = sc.nextLine();

//         System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
//         String fechaStr = sc.nextLine();
//         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//         Date fechaNacimiento = null;

//         try {
//             fechaNacimiento = sdf.parse(fechaStr);
//         } catch (ParseException e) {
//             System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
//         }

//         System.out.println("Ingrese su pais de correspondencia: ");
//         String paisCorrespondencia = sc.nextLine();

//         System.out.println("Ingrese su departamento de correspondencia: ");
//         String departamentoCorrespondencia = sc.nextLine();

//         System.out.println("Ingrese su municipio de correspondencia: ");
//         String municipioCorrespondencia = sc.nextLine();

//         System.out.println("Ingrese su direccion de correspondencia: ");
//         String direccionCorrespondencia = sc.nextLine();

//         System.out.println("Ingrese su email de correspondencia: ");
//         String emailCorrespondencia = sc.nextLine();

//         System.out.println("Ingrese su telefono de correspondencia: ");
//         String telefonoCorrespondencia = sc.nextLine();

//         // Crear objeto de tipo Nacimiento
//         Nacimiento nacimiento = new Nacimiento(paisNacimiento, departamentoNacimiento, municipioNacimiento, fechaNacimiento);
           
//         // Crear objeto de tipo Correspondencia
//         Correspondencia correspondencia = new Correspondencia(paisCorrespondencia, departamentoCorrespondencia, municipioCorrespondencia, direccionCorrespondencia, emailCorrespondencia, telefonoCorrespondencia);

//         // Crear objeto de tipo Persona
//         Persona persona = new Persona(numeroIdentificacion, tipoIdentificacion, nacionalidad, genero, nombre, apellido, direccion, telefono, correo, nacimiento, correspondencia);
        
//         // Imprimir los atributos de la persona

//         System.out.println("Numero de identificacion: " + persona.getID());
//         System.out.println("Tipo de identificacion: " + persona.getTipoId());
//         System.out.println("Nacionalidad: " + persona.getNacionalidad());
//         System.out.println("Genero: " + persona.getSexo());
//         System.out.println("Nombre: " + persona.getNombre());
//         System.out.println("Apellido: " + persona.getApellido());
//         System.out.println("Direccion: " + persona.getDireccion());
//         System.out.println("Telefono: " + persona.getTelefono());
//         System.out.println("Correo: " + persona.getCorreo());
//         System.out.println("Pais de nacimiento: " + persona.getInformacionNacimiento().getPais());
//         System.out.println("Departamento de nacimiento: " + persona.getInformacionNacimiento().getDepartamento());
//         System.out.println("Municipio de nacimiento: " + persona.getInformacionNacimiento().getMunicipio());
//         System.out.println("Fecha de nacimiento: " + sdf.format(persona.getInformacionNacimiento().getFecha()));
//         System.out.println("Pais de correspondencia: " + persona.getInformacionCorrespondencia().getPais());
//         System.out.println("Departamento de correspondencia: " + persona.getInformacionCorrespondencia().getDepartamento());
//         System.out.println("Municipio de correspondencia: " + persona.getInformacionCorrespondencia().getMunicipio());
//         System.out.println("Direccion de correspondencia: " + persona.getInformacionCorrespondencia().getDireccion());
//         System.out.println("Email de correspondencia: " + persona.getInformacionCorrespondencia().getEmail());
//         System.out.println("Telefono de correspondencia: " + persona.getInformacionCorrespondencia().getTelefono());

//         // CERRAR SCANNER

//         sc.close();
//     }
// }
