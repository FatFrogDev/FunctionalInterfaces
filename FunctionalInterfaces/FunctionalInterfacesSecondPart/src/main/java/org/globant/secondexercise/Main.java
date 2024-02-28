package org.globant.secondexercise;

import org.globant.secondexercise.exceptions.WritingReportFailException;
import org.globant.secondexercise.interfaces.IReportGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IReportGenerator reportGenerator = new ReportExporter();;

        System.out.println("Number sum is: " + Streams.numberAdder(Streams.randomNumbers));
        System.out.println("Products with color blue, red or yellow: ");
        Streams.productsBlueRedOrYellow(Streams.randomProducts).forEach(System.out::println);

        System.out.println("Generating report...");
        try {
            reportGenerator.generateReport(Arrays.asList(
                    new Product("13cc1211","toy car",Color.RED, 15.0),
                    new Product("13fj1215","Bike", Color.BLACK, 150.0),
                    new Product("13fq1235","Motorcycle", Color.GREEN, 1500.0)
            ),"C:/Users/deyby.ariza/Documents/report.txt");
            System.out.println("Report generated successfully!");
        } catch (WritingReportFailException e) {
            System.out.println("Whoops! Something went wrong generating the report: ");
            throw new RuntimeException(e);
        }

    }
}
