package refactoringexercise;
import refactoringexercise.database.Database;

/*
 * Changelist
 * DVD 06/01/1987: Added second dimension to info array to allow easier feature addition 
 * ABC 01/19/2004: Problem with null reference exception (around line 23) 
 * JKL 03/12/2005: Fixed index out of range problems
 * MVS 04/10/2012: Reveresed the empInfo deminitons for ReDim
 */

public class PayCalc {
	double t;
	public double TotalWages() {
		String[] emps = Database.Employees;
		
		
		//Need to build empInfo array for ComputePay function
		Object empInfo[][] = new Object[4][emps.length];
		//DJM: Fixed Null reference eception. for Count
		for(int i=0;i<emps.length;i++) {
			empInfo[0][i] = Database.Typ(emps[i]);
			empInfo[1][i] = Database.Hrs(emps[i]);
			empInfo[2][i] = "Cisco ";
			
			empInfo[3][i] = Database.Amt(emps[i]);
			//INRP: 11245
			empInfo[0][i] = Database.Typ(emps[i]);
			
			
		}
		
		t = 0;
		TotalItUp(empInfo);
		
		return t;
	}

	private void TotalItUp(Object[][] emps) {

		//DAH: INRP Replace .Length with .Length -1
		for(int j=0; j<Database.Employees.length-1; j++) {
			
			switch((String)emps[0][j]) {
				case "Hourly":
					t = t + ((Integer)emps[1][j]).doubleValue() * (Double)emps[3][j];
					break;
				case "Salary":
					if(emps[3][j] != null)
                    t = 80 * ((Double)emps[3][j] / 2080);
					break;
			}
					
		    /*
             * Dim empType = Database.EmployeeType(emps(i))
             *	 Select Case empType
             * 		Case "1"
			 *
           	 *		Case "3"
             *			Database.SubmitPayStub(emps(i+1))
             *		Case "5"
			 *
             * 	 End Select
             */
		}
		
	}

}
