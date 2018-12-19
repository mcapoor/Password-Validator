import java.util.Scanner;

public class Entropy {

	public static void automaticCalculator() {
		//given a string, the function calculates the entropy and rates its strength according to an arbitrary metric 

		System.out.println("Password: ");
		
		Scanner scan = new Scanner(System.in); 
		String pass = scan.nextLine();	
			//takes the user input 
		
		int length = pass.length();
				//gets the length of the user password
		String temp = "";
		for (int i = 0; i < length; i++) {
			if(temp.indexOf(pass.charAt(i)) == -1 ){
				temp = temp + pass.charAt(i);
			//dumps each unique character of the password into a new string
			}
		}
		int uniqueChars = temp.length();
			//gets the length of that new string (number of unique characters in the password)
		
		double entropy = Math.pow(uniqueChars, length);
			//entropy = number of unique characters ^ length of the word
		
		double bits = Math.log(entropy) / Math.log(2);
			//bits is log2(entropy)
		
		System.out.println("Entropy: " + entropy);
		System.out.println("Bits: " + bits);
		
		double sec = entropy/ 1000;
		double min = sec / 60;
		double hour = min / 60;
		double day = hour / 24;
		double year = day / 365;
			//length for computer to guess password in different time increments
		
		String intro = "This password is ";
		String veryWeak = "Very Weak; might keep out family members";
		String weak = "Weak; should keep out most people, often good for desktop login passwords";
		String reasonable = "Reasonable; fairly secure passwords for network and company passwords";
		String strong = "Strong; can be good for guarding financial information";
		String veryStrong = "Very Strong; often overkill";
			//from http://rumkin.com/tools/password/passchk.php 
		
		if (bits < 28) {
			System.out.println(intro + veryWeak);
		} else if (bits >= 28 && bits <= 35) {
			System.out.println(intro + weak);
		} else if (bits >= 36 && bits <= 59) {
			System.out.println(intro + reasonable);
		} else if (bits >= 60 && bits <= 127) {
			System.out.println(intro + strong);
		} else if (bits >= 128) {
			System.out.println(intro + veryStrong);
		}
			//displays the appropriate info from the previous block
		
		if (year > 1) {
			System.out.println("Time in years to guess password at 1000 guesses per second: " + year);	
		} else if (year < 1 && day > 1) {
			System.out.println("Time in days to guess password at 1000 guesses per second: " + day);
		} else if (day < 1 && hour > 1) {
			System.out.println("Time in hours to guess password at 1000 guesses per second: " + hour);
		} else if (hour < 1 && min > 1) {
			System.out.println("Time in minutes to guess password at 1000 guesses per second: " + min);
		} else {
			System.out.println("Time in seconds to guess password at 1000 guesses per second: " + sec);
		}
			//intuitive time interval 
	}
	
	public static void main(String[] args) {
		automaticCalculator();
		//calls function in main method
	}
}