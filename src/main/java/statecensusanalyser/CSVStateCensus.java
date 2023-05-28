package statecensusanalyser;

import com.opencsv.CSVWriter;

import java.io.*;
import java.io.IOException;

public class CSVStateCensus {

	public static void main(String[] args) {
		String filepath = "C:\\Users\\Prudhvi\\Desktop\\CensusForStates.csv";

		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filepath))) {
			/*
			 * Adding header to csv
			 */
			String[] header = { "StateName", "StatePopulation", "StateArea" };
			csvWriter.writeNext(header);
			/*
			 * Adding data to csv.
			 */
			String[] data1 = { "Andhra Pradesh", "4,00,000", "2,76,754" };
			csvWriter.writeNext(data1);
			String[] data2 = { "Telangana", "5,00,000", " 1,14,840" };
			csvWriter.writeNext(data2);
			
			System.out.println("CSV file created successfully");
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}