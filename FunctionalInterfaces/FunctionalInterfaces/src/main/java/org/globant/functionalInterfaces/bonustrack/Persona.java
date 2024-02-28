package org.globant.functionalInterfaces.bonustrack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Persona class, states for a person with three basic attributes, name, lastname and date birth.
 * <p>
 * Handles the business rules to logically create a valid person
 */
public class Persona {
    private String nombre;
    private String appellido;
    private LocalDate fechaNacimiento;

    /**
     * Valid weather a "nombre" is valid to be in a person object.
     * <p>
     * It does states if the name is seteable or not through various functional interfaces (Predicate).
     *
     * @param name Name of the person.
     * @return true | false
     */
    private boolean isSeteableName(String name) {
        return isValidNameLength.
                and(validateWhiteSpaces.
                        and(isValidFormatName)).
                test(name);
    }

    /**
     * Valid weather an "apellido" is valid to be in a person object.
     * <p>
     * It does states if the lastname is seteable or not through various functional interfaces (Predicate).
     *
     * @param appellido Name of the person.
     * @return true | false
     */
    private boolean isSeteableLastName(String appellido) {
        return isValidLastNameLength.
                and(validateWhiteSpaces
                        .and(isValidFormatName)).
                test(appellido);
    }


    /**
     * Parses a string with a date to a LocalDate object.
     * <p>
     * If not possible, returns null value and prints a message, otherwise, return the LocalDate parsed object.
     *
     * @param fechaNacimiento Date of birth of the person.
     * @return LocalDate | null.
     */
    public LocalDate parseFechaNacimiento(String fechaNacimiento) {
        // Analyze the format date given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(fechaNacimiento, formatter);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al convertir la fecha de nacimiento.");
            return null;
        }
    }

    ;

    /**
     * Validates if the given parameter has the minimal length required.
     *
     * @Param apellido String to be analyzed.
     * @returns true|false.
     */
    Predicate<String> isValidLastNameLength = (apellido) -> !(apellido.length() < 3);

    /**
     * Validates if the given parameter has the minimal length required.
     *
     * @Param name String to be analyzed.
     * @returns true|false.
     */
    Predicate<String> isValidNameLength = (name) -> !name.isEmpty();

    /**
     * Validates that the given string doesn't have any space in the beginning or in the end of the same.
     *
     * @Param name String to be analyzed.
     * @returns true|false.
     */
    Predicate<String> validateWhiteSpaces = (name) -> {
        char[] splitName = name.toCharArray();
        return !Character.isWhitespace(splitName[0])
                && !Character.isWhitespace(splitName[splitName.length - 1]);
    };

    /**
     * Validates if a given string has the correct format and is seteable as a "nombre".
     * Usees a {@link  java.util.regex.Pattern} object to verify if the name has
     * between 3-10 characters of length and accept character accentuation.
     *
     * @Param name String to be analyzed.
     * @returns true|false.
     */
    Predicate<String> isValidFormatName = (name) -> {
        name = name.toUpperCase();
        // Patter accept characters with accentuation
        Pattern pattern = Pattern.compile("^[A-Z\\u00C0-\\u017F]{3,10}$");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    };

    /**
     * Validates if a given date birth is valid to considerate a "persona" as "mayor de edad".
     *
     * @Param dateOfBirth date of birth of the person.
     * @returns true|false.
     */
    Predicate<LocalDate> isLegalAge = (dateOfBirth) -> {
        LocalDate lowerDate = LocalDate.now().minusYears(18L);
        return dateOfBirth.isAfter(lowerDate);
    };


    public String getNombre() {
        return this.nombre;
    }

    ;

    public void setNombre(String nombre) {
        if (isSeteableName(nombre)) this.nombre = nombre;
    }

    ;

    public String getAppellido() {
        return appellido;
    }

    ;

    public void setAppellido(String appellido) {
        if (isSeteableLastName(appellido)) this.appellido = appellido;
    }

    ;

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    ;


    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (isLegalAge.test(fechaNacimiento)) this.fechaNacimiento = fechaNacimiento;
    }

    ;
}

