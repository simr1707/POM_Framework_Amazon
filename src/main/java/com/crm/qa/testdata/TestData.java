package com.crm.qa.testdata;

public class TestData {
	
	public static String blankYourname,correctEmail, correctPassword, correctPasswordAgain, correctYourame, blankEmail;

	public static void main(String[] args) {
		Xls_Reader xls_Reader = new Xls_Reader("D:\\QA\\Testing\\AmazonSignUpData.xlsx");
		
		blankYourname = xls_Reader.getCellData("SignupData","Yourname",2);
		correctEmail = xls_Reader.getCellData("SignupData", "MobileorEmail", 2);
		correctPassword = xls_Reader.getCellData("SignupData","Password",2);
		correctPasswordAgain = xls_Reader.getCellData("SignupData", "Passwordagain", 2);
		
		correctYourame = xls_Reader.getCellData("SignupData","Yourname",3);
		blankEmail = xls_Reader.getCellData("SignupData", "MobileorEmail", 3);
		correctPassword = xls_Reader.getCellData("SignupData","Password",3);
		correctPasswordAgain = xls_Reader.getCellData("SignupData", "Passwordagain", 3);
		}
}	