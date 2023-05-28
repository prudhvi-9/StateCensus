package statecensusanalysertest;
import org.junit.Test;
import statecensusanalyser.StateCensusAnalyser;
import statecensusanalyser.StateCensusException;

import org.junit.jupiter.api.Assertions;

public class StateAnalyserTest {
	private static final String file = "C:\\Users\\Prudhvi\\Desktop\\CensusForStatest.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() throws  StateCensusException {
		StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
		int numOfRecords = 0;
		try {
			numOfRecords = censusAnalyser.loadIndiaCensusData(file);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Assertions.assertEquals(2, numOfRecords);
	}
}
