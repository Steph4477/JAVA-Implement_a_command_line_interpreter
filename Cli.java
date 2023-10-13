/* 
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class Cli {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			Date today = new Date();
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			}
			if (command.equals("date")) {
				DateFormat date = DateFormat.getDateInstance(
					DateFormat.SHORT, new Locale("FR", "fr")
				);
				System.out.println(date.format(today));
			}
			if (command.equals("time")) {
				DateFormat time = DateFormat.getTimeInstance(
					DateFormat.SHORT, new Locale("FR", "fr")
				);
				System.out.println(time.format(today));
			}  
			if (command.equals("datetime")) {
				DateFormat dateTime = DateFormat.getDateTimeInstance(
					DateFormat.SHORT,
					DateFormat.SHORT, new Locale("FR", "fr")
				);
				System.out.println(dateTime.format(today));
			} 
			 else {
				// String concatenation
				output = "Command " + command + " not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
	}

}*/
import java.util.Scanner;
import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime; // import the LocalTime class
import java.time.LocalDateTime; // import the LocalDateTime class

public class Cli {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			}
			if (command.equals("date")) {
				LocalDate today = LocalDate.now();
				System.out.println(today);
			}
			if (command.equals("time")) {
				LocalTime today = LocalTime.now();
				System.out.println(today);
			}  
			if (command.equals("datetime")) {
				LocalDateTime today = LocalDateTime.now();
				System.out.println(today);
			}
			 else {
				// String concatenation
				output = "Command " + command + " not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
	}

}