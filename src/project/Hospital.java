package project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Hospital {

    static String id, name, lastName, phone, type, date;
    static ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
    static ArrayList<String> user = new ArrayList<String>();
    static ArrayList<ArrayList<String>> citas = new ArrayList<ArrayList<String>>();
    static ArrayList<String> cita = new ArrayList<String>();
    static double price;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
      Menu();
    }

    public static void Registrar(){

        System.out.println("Bienvenido a tu registro ---");
        IngresarDatos();
        ArrayList<String> user = new ArrayList<>();
        user.add(id);
        user.add(name);
        user.add(lastName);
        user.add(phone);

        users.add(user);

    }

    public static void ShowLogs(ArrayList<ArrayList<String>>matriz){
        if(matriz.isEmpty()){
            System.out.println("No hay registros...");
        }
        System.out.println("Registros ---");
        for(ArrayList<String> fila : matriz){
            for(String element : fila){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void Citar(){
        System.out.println("Bienvenido a registrar citas ---");
        IngresarDatos();
        System.out.println("Ingrese la fecha de la cita: ");
        date = sc.next();
        System.out.println("--- Tipo de cita " + "\n" + "1- General "+ "\n" + "2- Odontología "+ "\n" + "3- oftalmologia");
        int op;
        System.out.println("seleccione una opcion: ");
        op = sc.nextInt();
        switch (op){
            case 1 : type = "General";
                     price = 10000;
            break;
            case 2: type = "Odontologia";
                    price = 10000;
            break;
            case 3: type = "oftalmologia";
                     price = 10000;
            break;
            default:
                System.out.println("Opcion no valida");
        }
        boolean idFound = false;
        for(ArrayList<String> fila : users){
                if(fila.contains(id)){
                    idFound = true;
                        String priceString = String.valueOf(price);
                        ArrayList<String> cita = new ArrayList<>();
                        cita.add(id);
                        cita.add(name);
                        cita.add(lastName);
                        cita.add(phone);
                        cita.add(type);
                        cita.add(date);
                        cita.add(priceString);
                        citas.add(cita);
                        break;
                }
        }
        if(!idFound){
            System.out.println("Resgitra el usuario para hacer una cita");
        }


    }

    public static void Menu(){
        String answer ;
        do{
            int op;
            System.out.println("Bienvenido al sistema basico de Hospital --- ");
            System.out.println("--- Menu " + "\n" + "1- Registrar Usuario "+ "\n"
                    + "2- registrar cita "+ "\n" + "3- Mostrar usuarios registrados" + "\n" + "4- Mostrar citas registradas "
            + "\n" + "5- salir");
            System.out.println("Seleccione una opcion: ");
            op = sc.nextInt();
            switch (op){
                case 1 : Registrar();
                    break;
                case 2: Citar();
                    break;
                case 3: ShowLogs(users);
                    break;
                case 4: ShowLogs(citas);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

            System.out.println("Desea realizar otra operacion S/N: ");
            answer = sc.next();

        }while(answer.equals("S") || answer.equals("s"));
    }

    public static void IngresarDatos(){
        System.out.println("Ingresa tu cedula: ");
        id = sc.next();
        System.out.println("Ingresa tu nombre: ");
        name = sc.next();
        System.out.println("Ingresa tu apellido: ");
        lastName = sc.next();
        System.out.println("Ingresa tu telefono: ");
        phone = sc.next();
    }
}
