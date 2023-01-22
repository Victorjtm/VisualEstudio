/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog05_ejerc1_util;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author vjtej
 */
public class MetodosEstaticos {

//Muestra el menu
    public static void mostrarMenu() {
        System.out.println("1-Nuevo Vehiculo.");
        System.out.println("2-Ver Matrícula.");
        System.out.println("3-Ver Número de Kilómetros.");
        System.out.println("4-Actualizar Kilómetros.");
        System.out.println("5-Ver años de antigüedad..");
        System.out.println("6-Mostrar propietario.");
        System.out.println("7-Mostrar descripción.");
        System.out.println("8-Mostrar Precio.");
        System.out.println("9-Salir.");

    }
//Solicita la etnrada de datos por teclado

    public static String pedirDatos(String cadena) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(cadena);
        String dato = entrada.nextLine();
        return dato;
    }

    // comprueba que relmente metemos un numero de matricula correcto.
    public static boolean validaMatricula(String cadena) {
        boolean correcto = false;
        int longitud;
        String cuatro;
        String tres;
        longitud = cadena.length();
        if (longitud > 7) {
            System.out.println("son demasiados caracteres, tienen que ser cuatro numeros y tres letras.");
            correcto = false;
            System.out.println("Intentalo de nuevo");
            return correcto;
        }
        if (longitud < 5) {
            System.out.println("no ha introducido suficientes caracteres para la matricula");
            correcto = false;
            System.out.println("Intentalo de nuevo");
            return correcto;
        }
        cuatro = cadena.substring(0, 4);
        if (!(validaEntero(cuatro))) {
            System.out.println("los primeros cuatro caracteres han de ser numeros.");
            correcto = false;
            System.out.println("Intentalo de nuevo");
            return correcto;
        }
        tres = cadena.substring(4, cadena.length());
        if (!(validaCaracter(tres))) {
            System.out.println("Los tres ultimos caracteres no son letras");
            correcto = false;
            System.out.println("Intentalo de nuevo");
            return correcto;
        }
        correcto = true;
        return correcto;
    }

    // Comprueba si una cadena de caracteres es un numero y no otros caracteres.
    public static boolean validaEntero(String cadena) {
        boolean correcto = false;
        int numero;
        try {
            numero = Integer.parseInt(cadena);
            correcto = true;
        } catch (NumberFormatException e) {
            System.out.println("No esta metiendo un numero el dato tiene que ser un numero entero");
            System.out.println("intentelo de nuevo");
            correcto = false;
        }
        return correcto;
    }

    //Comprueba si una cadena de caracteres son letras de la a a la z
    public static boolean validaCaracter(String cadena) {
        boolean correcto = true;
        char letra;
        for (int i = 0; i < cadena.length(); i++) {
            letra = cadena.charAt(i);
            if (!((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z'))) {
                correcto = false;
                return correcto;
            }

        }
        return correcto;
    }
//Comprueba si es una matricula correcta

    public static boolean validaKilometros(String cadena) {
        boolean correcto = true;
        int numero;
        try {
            numero = Integer.parseInt(cadena);
            correcto = true;
            if (numero <= 0) {
                correcto = false;
                System.out.println("El numero de kilometros no puede ser inferior a 1");
                System.out.println("Intentalo de nuevo");
            }
        } catch (NumberFormatException e) {
            System.out.println("El numero de Kilometros debe ser un numero entero");
            System.out.println("Intentalo de nuevo");
            correcto = false;
        }
        return correcto;
    }
//Comprueba si el día es correcto y si el año es o no bisieto y lo valida

    public static boolean validaDia(String cadena, int mes, int anio) {
        boolean correcto = false;
        int dia = Integer.parseInt(cadena);
        if (dia < 1 || dia > 31) {
            System.out.println("el día tiene que ser entre 1 y 31");
            System.out.println("vuelve a intentarlo");
            correcto = false;
            return correcto;
        }
        if (dia > 28 && mes == 2 && (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
            System.out.println("el " + anio + " es bisiesto y por tanto el dia no puede ser mayor que 28: ");
            System.out.println("vuelve a intentarlo");
            correcto = false;
            return correcto;
        }
        correcto = true;
        return correcto;
    }
//Comprueba si el mes es correcto

    public static boolean validaMes(String cadena) {
        boolean correcto = false;
        int mes = Integer.parseInt(cadena);
        if (mes < 1 || mes > 12) {
            System.out.println("el mes tiene que ser entre 1 y 12");
            System.out.println("vuelve a intentarlo");
            correcto = false;
            return correcto;
        }
        correcto = true;
        return correcto;
    }
//Compureba si el año es correcto

    public static boolean validaAnio(String cadena) {
        boolean correcto = false;
        int anio = Integer.parseInt(cadena);
        LocalDate fecha = LocalDate.now();
        int anioActual = fecha.getYear();
        if (anio < 1 || anio > anioActual) {
            System.out.println("el año tiene que ser entre el 1 y el " + anioActual);
            System.out.println("vuelve a intentarlo");
            correcto = false;
            return correcto;
        }
        correcto = true;
        return correcto;
    }
//Comprueba si el DNI es correcto

    public static boolean validaDni(String cadena) {
        boolean correcto = false;
        int longitud;
        String numDni;
        // comprueba la longitud de los caracteres de entraa
        longitud = cadena.length();
        if (longitud < 8 || longitud > 9) {
            System.out.println("no es correcto, tienes que meter entre 7 y 8 digitos y una letra: ");
            correcto = false;
            System.out.println("Intentalo de nuevo");
            return correcto;
        }
        // Comprueba si los digitos antes de la letra son un numero entero
        numDni = cadena.substring(0, cadena.length() - 1);
        if (!(validaEntero(numDni))) {
            System.out.println("los primeros caracteres han de ser numeros");
            correcto = false;
            System.out.println("Intentalo de nuevo");
            return correcto;
        }
        //Busca la letra correcta para el DNI
        String recortaLetra = cadena.substring(cadena.length() - 1, cadena.length());
        recortaLetra = recortaLetra.toUpperCase();
        char letra = recortaLetra.charAt(0);
        //System.out.println("LA LETRA RECORTADA ES: " + letra);
        final int DIVISOR = 23;
        char letrasDni[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = Integer.parseInt(numDni) % DIVISOR;
        char letraBuena = letrasDni[resto];
        //Comprueba si la letra que hemos metido es la correcta
        if (letraBuena != letra) {
            System.out.println("El DNI introducido no es valido: ");
            correcto = false;
            System.out.println("Intentalo de nuevo");
            return correcto;
        }
        correcto = true;
        return correcto;
    }
//Convierte numero a moneda

    public static String formatearMoneda(double numero) {
        //NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        return formato.format(numero);
    }
//Convierte numero a numero separado por puntos

    public static String formatearNumero(int numero) {
        NumberFormat formatoNumero = NumberFormat.getNumberInstance();
        return formatoNumero.format(numero);
    }

}
