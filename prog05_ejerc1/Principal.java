/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package prog05_ejerc1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import static prog05_ejerc1_util.MetodosEstaticos.*;
// PRGOGRAMA ENTRADA Y SALIDA VEHICULOS
/**
 *
 * @author vjtej
 */
public class Principal {

    public static void main(String[] args) {
        // Inicio de variables 
        String marca = null;
        String matricula = null;
        int kilometros = 0;
        Date fechaMatricula = null;
        String descripcion = null;
        double precio = 0;
        String propietario = null;
        int dni = 0;
        String nif = null;
        int anio = 0;
        int mes = 0;
        int dia = 0;
        int opcion = -1;
        boolean correcto = false;
        Vehiculo auto = new Vehiculo(marca, matricula, kilometros, fechaMatricula, descripcion, precio, propietario, dni, nif, anio, mes, dia);
        try {

            while (opcion != 9) {

                mostrarMenu();
                String opp = pedirDatos("Opcion? ");
                try {
                    opcion = Integer.parseInt(opp);
                } catch (Exception e) {
                    System.out.println("TAREA PROGRAMACION 05");
                    System.out.println("BASE DE DATOS DE VEHICULO");
                    System.out.println("Debe introducir una opcion del 1 al 9");
                    System.out.println("Intentelo de nuevo");
                    opcion = -1;
                }

                switch (opcion) {
                    case 0:
                        System.out.println(auto.toString());
                        break;
                    case 1:
                        while (marca == null) {
                            marca = pedirDatos("Marca vehiculo: ");
                            marca = marca.toUpperCase();
                            if (marca == "") {
                                System.out.println("Debe introducir los datos");
                                marca = null;
                            } else {
                                auto.setMarca(marca);
                            }
                        }
                        correcto = false;
                        while (!correcto) {
                            matricula = pedirDatos("Numero de matricula: ");
                            correcto = validaMatricula(matricula);
                            if (correcto) {
                                matricula = matricula.toUpperCase();
                                auto.setMatricula(matricula);
                            }
                        }
                        correcto = false;
                        while (!correcto) {
                            String kilometrosSinValidar = pedirDatos("Numero de kilometros: ");
                            correcto = validaKilometros(kilometrosSinValidar);
                            if (correcto) {
                                kilometros = Integer.parseInt(kilometrosSinValidar);
                                auto.setNumeroKm(kilometros);
                            }
                        }
                        correcto = false;
                        while (!correcto) {
                            String anioSinValidar = pedirDatos("Anio de matriculacion: ");
                            correcto = validaEntero(anioSinValidar);
                            if (correcto) {
                                correcto = validaAnio(anioSinValidar);
                                anio = Integer.parseInt(anioSinValidar);
                                auto.setAnio(anio);
                            }
                        }
                        correcto = false;
                        while (!correcto) {
                            String mesSinValidar = pedirDatos("Mes de matriculacion: ");
                            correcto = validaEntero(mesSinValidar);
                            if (correcto) {
                                correcto = validaMes(mesSinValidar);
                                mes = Integer.parseInt(mesSinValidar);
                                auto.setMes(mes);
                            }
                        }
                        correcto = false;
                        while (!correcto) {
                            String diaSinValidar = pedirDatos("Dia de matriculacion: ");
                            correcto = validaEntero(diaSinValidar);
                            if (correcto) {
                                correcto = validaDia(diaSinValidar, auto.getMes(), auto.getAnio());
                            }
                            if (correcto) {
                                dia = Integer.parseInt(diaSinValidar);
                                auto.setDia(dia);
                                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                                String fechaCadena = auto.getDia() + "/" + auto.getMes() + "/" + auto.getAnio();
                                try {
                                    auto.setFechaMatricula(formatoFecha.parse(fechaCadena));
                                    //auto.setFechaMatricula(fecha);
                                    correcto = true;
                                } catch (Exception e) {
                                    System.out.println("error en el formato de fecha");
                                    correcto = false;
                                }
                            }
                        }
                        while (descripcion == null) {
                            descripcion = pedirDatos("Descripcion del vehiculo: ");
                            marca = descripcion.toUpperCase();
                            if (descripcion == "") {
                                System.out.println("Debe introducir los datos");
                                descripcion = null;
                            } else {
                                auto.setDescripcion(descripcion);
                            }
                        }
                        correcto = false;
                        while (!correcto) {
                            String precioSinValidar = pedirDatos("Precio del vehiculo: ");
                            correcto = validaEntero(precioSinValidar);
                            if (correcto) {
                                precio = Integer.parseInt(precioSinValidar);
                                auto.setPrecio(precio);
                            }
                        }
                        while (propietario == null) {
                            propietario = pedirDatos("Nombre del propietaro del vehiculo: ");
                            propietario = propietario.toUpperCase();
                            if (propietario == "") {
                                System.out.println("Debe introducir los datos");
                                propietario = null;
                            } else {
                                auto.setPropietario(propietario);
                            }
                        }
                        correcto = false;
                        while (!correcto) {
                            nif = pedirDatos("Numero de DNI: ");

                            correcto = validaDni(nif);
                            if (correcto) {
                                dni = Integer.parseInt(nif.substring(0, nif.length() - 1));
                                auto.setDni(dni);
                                auto.setNif(nif);
                            }
                        }

                        break;
                    case 2:
                        if (auto.getMatricula() != null) {;
                            System.out.println("LA MATRICULA DEL VEHICULO ES: " + auto.getMatricula());
                        } else {
                            System.out.println("NO HAY DATOS DEL VEHICULO, SELECCION LA OPCION 1 DEL MENU PARA INTRODUCIR DATOS");
                        }
                        break;
                    case 3:
                        if (auto.getNumeroKm() != 0) {;

                            System.out.println("LO KILOMETROS QUE TIENE EL VEHICULO SON: " + formatearNumero(auto.getNumeroKm()) + " KM");
                        } else {
                            System.out.println("NO HAY DATOS DEL VEHICULO, SELECCION LA OPCION 1 DEL MENU PARA INTRODUCIR DATOS");
                        }
                        break;
                    case 4:
                        if (auto.getNumeroKm() == 0) {
                            System.out.println("NO HAY DATOS DEL VEHICULO, SELECCION LA OPCION 1 DEL MENU PARA INTRODUCIR DATOS");
                            correcto = true;
                            break;
                        } else {
                            correcto = false;
                        }
                        while (!correcto) {
                            String actualizaKm = pedirDatos("Indica cuantos kilometros tienes ahora");
                            correcto = validaEntero(actualizaKm);
                            if (correcto && Integer.parseInt(actualizaKm) <= auto.getNumeroKm()) {
                                System.err.println("el numero de kilometros a actualizar no puede ser igual o menor del que ya tenia");
                                System.out.println("Eliga opcion de nuevo");
                            }
                            if (correcto && Integer.parseInt(actualizaKm) > auto.getNumeroKm()) {
                                int resultado = Integer.parseInt(actualizaKm) - auto.getNumeroKm();
                                System.out.println("El numero de kilometros se ha aumentado en: " + formatearNumero(resultado));
                                auto.setNumeroKm(Integer.parseInt(actualizaKm));
                                correcto = true;
                            }
                        }
                        break;
                    case 5:
                        if (auto.getAnio() == 0) {
                            System.out.println("NO HAY DATOS DEL VEHICULO, SELECCION LA OPCION 1 DEL MENU PARA INTRODUCIR DATOS");
                            break;
                        }

                        LocalDate fecha = LocalDate.now();
                        int anioActual = fecha.getYear();
                        int mesActual = fecha.getMonthValue();
                        int diaActual = fecha.getDayOfMonth();
                        int resultado = anioActual - auto.getAnio();

                        if (mesActual < auto.getMes()) {
                            resultado = anioActual - auto.getAnio() - 1;
                        }
                        if (mesActual == auto.getMes() && diaActual < auto.getDia()) {
                            resultado = anioActual - auto.getAnio() - 1;
                        }

                        System.out.println("El numero de años que han pasado desde la matriculacion es: " + resultado);
                        LocalDate fechaMatriculacion = LocalDate.of(auto.getAnio(), auto.getMes(), auto.getDia());
                        LocalDate fechaActual = LocalDate.now();
                        Period periodoAnyosAntiguedad = Period.between(fechaMatriculacion, fechaActual);
                        int anyosAntiguedad = periodoAnyosAntiguedad.getYears();
                        System.err.println("lo años que salen con localdate son:" + anyosAntiguedad);

                        break;
                    case 6:
                        if (auto.getPropietario() == null) {
                            System.out.println("NO HAY DATOS DEL VEHICULO, SELECCION LA OPCION 1 DEL MENU PARA INTRODUCIR DATOS");
                        } else {
                            System.out.println("El nombre del propietario del Vechiculo es: " + auto.getPropietario() + " y su NIF es: " + auto.getNif());
                        }
                        break;
                    case 7:
                        if (auto.getDescripcion() == null) {
                            System.out.println("NO HAY DATOS DEL VEHICULO, SELECCION LA OPCION 1 DEL MENU PARA INTRODUCIR DATOS");
                        } else {
                            System.out.println("La descripcion del Vechiculo es: " + auto.getDescripcion()
                                    + ", su Matricula es: " + auto.getMatricula() + " y su Numero de kilometros es: " + formatearNumero(auto.getNumeroKm()) + " KM");
                        }
                        break;
                    case 8:
                        if (auto.getPrecio() == 0) {
                            System.out.println("NO HAY DATOS DEL VEHICULO, SELECCION LA OPCION 1 DEL MENU PARA INTRODUCIR DATOS");
                        } else {
                            System.out.println("El Precio del Vechiculo es: " + formatearMoneda(precio));
                        }
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Debe elegir una opion del 1 al 9");
        }

    }
}
