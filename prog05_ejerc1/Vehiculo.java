/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog05_ejerc1;

import java.util.Date;

/**
 *
 * @author vjtej
 */
public class Vehiculo {

    // atributos de la clase vehiculo
    String marca;
    String matricula;
    int numeroKm;
    Date fechaMatricula;
    String descripcion;
    double precio;
    String propietario;
    int dni;
    String nif;
    int anio;
    int mes;
    int dia;

    // constructores de la clase vehiculo
    public Vehiculo(String marca, String matricula, int numeroKm, Date fechaMatricula, String descripcion, double precio, String propietario, int dni, String nif, int anio, int mes, int dia) {
        this.marca = marca;
        this.matricula = matricula;
        this.numeroKm = numeroKm;
        this.fechaMatricula = fechaMatricula;
        this.descripcion = descripcion;
        this.precio = precio;
        this.propietario = propietario;
        this.dni = dni;
        this.nif = nif;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    // Creando get y set
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumeroKm() {
        return numeroKm;
    }

    public void setNumeroKm(int numeroKm) {
        this.numeroKm = numeroKm;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", numeroKm=" + numeroKm + ", fechaMatricula=" + fechaMatricula + ", descripcion=" + descripcion + ", precio=" + precio + ", propietario=" + propietario + ", dni=" + dni + ", nif=" + nif + ", anio=" + anio + ", mes=" + mes + ", dia=" + dia + '}';
    }

}

