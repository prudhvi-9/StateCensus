package statecensusanalyser;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class IndianStateCodeCensus {

	public static void main(String[] args) {
		String filepath = "C:\\Users\\Prudhvi\\Desktop\\CensusForIndianStatesCode.csv";

		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filepath))) {
			/*
			 * Adding header to csv
			 */
			String[] header = { "StateName", "StateCode" };
			csvWriter.writeNext(header);
			/*
			 * Adding data to csv.
			 */
			String[] data1 = { "Bihar", "1" };
			csvWriter.writeNext(data1);
			String[] data2 = { "Kerala", "2" };
			csvWriter.writeNext(data2);

			System.out.println("CSV file created successfully");
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

}
