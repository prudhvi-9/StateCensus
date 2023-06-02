package statecensusanalysertest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

import statecensusanalyser.IndianStateCodeCensusAnalyser;
import statecensusanalyser.StateCensusAnalyser;
import statecensusanalyser.StateCensusException;

public class IndianStateCodeTest {

	private static final String filepath = "C:\\Users\\Prudhvi\\Desktop\\CensusForIndianStatesCode.csv";
	private static final String WRONG_CSV_FILE_PATH = "C:\\Users\\Prudhvi\\Desktop\\IndiaStateCensus.csv";
	private static final String WRONG_CENSUS_FILE_EXTENSION = "C:\\Users\\Prudhvi\\Desktop\\CensusForStatest.sh";
	private static final String INDIA_CENSUS_CSV_FILE_WRONG_DELIMITER = "C:\\Users\\Prudhvi\\Desktop\\WrongDelimiter.csv";
	private static final String INDIA_CENSUS_CSV_FILE_WRONG_HEADER = "C:\\Users\\Prudhvi\\Desktop\\WrongHeader.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() throws StateCensusException {
		IndianStateCodeCensusAnalyser censusAnalyser = new IndianStateCodeCensusAnalyser();
		int numOfRecords = 0;
		try {
			numOfRecords = censusAnalyser.loadIndiaCensusData(filepath);
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
