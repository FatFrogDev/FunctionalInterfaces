package org.globant.firstexercise;

public class Person {
    private String nombre;

    private String documento;

    private String direccion;

    private int edad;

    public Person(String nombre, String documento, String direccion, int edad) {
        this.nombre= nombre;
        this.documento = documento;
        this.direccion = direccion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Documento: " + documento + ", Dirección: " + direccion + ", Edad: " + edad + " años";
    }
}