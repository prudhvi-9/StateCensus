package statecensusanalysertest;

import org.junit.Test;
import statecensusanalyser.StateCensusAnalyser;
import statecensusanalyser.StateCensusException;

import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class StateAnalyserTest {

	private static final String file = "C:\\Users\\Prudhvi\\Desktop\\CensusForStatest.csv";
	private static final String WRONG_CSV_FILE_PATH = "C:\\Users\\Prudhvi\\Desktop\\IndiaStateCensus.csv";
	private static final String WRONG_CENSUS_FILE_EXTENSION = "C:\\Users\\Prudhvi\\Desktop\\CensusForStatest.sh";
	private static final String INDIA_CENSUS_CSV_FILE_WRONG_DELIMITER = "C:\\Users\\Prudhvi\\Desktop\\WrongDelimiter.csv";
	private static final String INDIA_CENSUS_CSV_FILE_WRONG_HEADER = "C:\\Users\\Prudhvi\\Desktop\\WrongHeader.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() throws StateCensusException {
		StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
		int numOfRecords = 0;
		try {
			numOfRecords = censusAnalyser.loadIndiaCensusData(file);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Assertions.assertEquals(2, numOfRecords);
	}

	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(StateCensusException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (StateCensusException e) {
			Assertions.assertEquals(StateCensusException.ExceptionType.Census_File_Invalid, e.type);
		}
	}

	@Test
	public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(StateCensusException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CENSUS_FILE_EXTENSION);
		} catch (StateCensusException e) {
			Assertions.assertEquals(StateCensusException.ExceptionType.Census_File_Invalid, e.type);
		}
	}

	@Test
	public void givenIndiaCensusData_WithWrongDelimiter_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(StateCensusException.class);
			censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_WRONG_DELIMITER);
		} catch (StateCensusException e) {
			Assertions.assertEquals(StateCensusException.ExceptionType.Incorrect_Delimiter, e.type);
		}
	}

	@Test
	public void givenIndiaCensusData_WithWrongHeader_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_WRONG_HEADER);
		} catch (StateCensusException e) {
			Assertions.assertEquals(StateCensusException.ExceptionType.Incorrect_header, e.type);
		}
	}
}
