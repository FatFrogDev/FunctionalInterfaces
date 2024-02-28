package org.globant.secondexercise;

import org.globant.secondexercise.exceptions.WritingReportFailException;
import org.globant.secondexercise.interfaces.IReportGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class ReportExporter implements IReportGenerator{

    /**
     * Generates a file in a declared format with the information of a given list of products. <br>
     *
     * @param outputPath the error message
     * @throws WritingReportFailException This exception is thrown when the report generation fails, due to the file already exists, the list of products is empty or an error occurs while writing the file.
     */
    @Override
    public void generateReport(List<Product> products, String outputPath) throws WritingReportFailException {
        File file = new File(outputPath);
        if (file.exists() && file.isFile()) {
            throw new WritingReportFailException("The file at " + outputPath + " location already exists", null);
        }
        if (products.isEmpty()) {
            throw new WritingReportFailException("The given list of products is empty, ", null);
        }
            try (
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
            ) {
                for (Product product : products) {
                    writer.write(product.toString());
                    writer.newLine();
                }
            } catch (Exception e) {
                throw new
                        WritingReportFailException("Error writing the report at " + outputPath, e);
            }
        }
}
