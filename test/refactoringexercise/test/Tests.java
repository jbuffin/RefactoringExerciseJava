package refactoringexercise.test;

import static org.junit.Assert.*;

import org.junit.Test;

import refactoringexercise.PayCalc;


public class Tests {

	@Test
	public void PayHourlyEmployee() {
		PayCalc payroll = new PayCalc();
		
		assertEquals(1807.69, payroll.TotalWages(), 0.01);
	}

}
