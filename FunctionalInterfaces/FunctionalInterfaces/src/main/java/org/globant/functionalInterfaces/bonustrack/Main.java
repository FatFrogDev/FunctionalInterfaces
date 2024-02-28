package org.globant.functionalInterfaces.bonustrack;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    /**
     * Main class
     * This class will set a "Persona" and its attributes with the requirements given. For the scanner data to be entered,
     * it is assumed that is "correct", this means the user gives the parameters following the sentences given through the console.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Persona persona = new Persona();
        System.out.println("Ingresa el nombre de la persona: ");
        persona.setNombre(scan.nextLine());
        System.out.println("Ingresa el apellido de la persona: ");
        persona.setNombre(scan.nextLine());
        System.out.print("Ingrese la fecha de nacimiento (dd/mm/aaaa): ");
        LocalDate fecha = persona.parseFechaNacimiento(scan.nextLine());
        persona.setFechaNacimiento(fecha);
    }
}
