package statecensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.stream.StreamSupport;

public class IndianStateCodeCensusAnalyser {

	public int loadIndiaCensusData(String filePath) throws StateCensusException {

		try (Reader reader = Files.newBufferedReader(Paths.get(filePath));) {

			CsvToBeanBuilder<IndianStateCodeCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);

			csvToBeanBuilder.withType(IndianStateCodeCensus.class);

			CsvToBean<IndianStateCodeCensus> csvToBean = csvToBeanBuilder.build();
			/*
			 * To iterate through the file.
			 */
			Iterator<IndianStateCodeCensus> censusCsvIterator = csvToBean.iterator();
			Iterable<IndianStateCodeCensus> csvIterable = () -> censusCsvIterator;
			/*
			 * To count the number of records in the file.
			 */
			int countOfTheRecords = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();

			return countOfTheRecords;

		} catch (IOException e) {
			throw new StateCensusException(e.getMessage(), StateCensusException.ExceptionType.Census_File_Invalid);

		} catch (IllegalStateException e) {
			throw new StateCensusException(e.getMessage(), StateCensusException.ExceptionType.Incorrect_Type);

		} catch (RuntimeException e) {
			throw new StateCensusException(e.getMessage(), StateCensusException.ExceptionType.Incorrect_Delimiter);
		}
	}
}
