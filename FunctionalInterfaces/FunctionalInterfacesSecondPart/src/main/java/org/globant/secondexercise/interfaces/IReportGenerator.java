package org.globant.secondexercise.interfaces;

import java.util.List;

import org.globant.secondexercise.Product;
import org.globant.secondexercise.exceptions.WritingReportFailException;


public interface IReportGenerator {
    /**
     * Generate report.
     *
     * @param products the list of products to be included in the report.
     * @param outputPath the output path where the report will be saved.
     * @throws WritingReportFailException
     */
    public void generateReport(List<Product> products, String outputPath) throws WritingReportFailException;
}
