import java.time.*;
import java.time.format.DateTimeFormatter;

public class TestMain {

	public static void main(String[] args) {

		wochentagSeit(1900, DayOfWeek.MONDAY);
		wochentag(2003, DayOfWeek.MONDAY, true);
		geburtstag(05, 02);
		
	}

	static void wochentag(int year, DayOfWeek Wo, boolean mmddyy) {
		String lastformatted = null;
		LocalDate lastday = null;
		int zaehler = 0;
		LocalDate thisye = LocalDate.of(year, 1, 1);
		do {
			if (thisye.getDayOfWeek().equals(Wo)) {
				lastday = thisye;
				zaehler++;
				if (mmddyy) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
					String formatted = formatter.format(thisye);
					lastformatted = formatter.format(lastday);
					System.out.println(formatted + " ist ein " + Wo + ".");
				} else {
					System.out.println(thisye + " ist ein " + Wo + ".");
				}
			}
			thisye = thisye.plusDays(1);
		} while (thisye.getYear() == year);
		System.out.println("Im Jahr " + year + " gibts es " + zaehler + " " + Wo + "s.\n");
		if (lastformatted != null) {
			System.out.println(lastformatted + " ist der letzte " + Wo + " im Jahr.\n");
		} else {
			System.out.println(lastday + " ist der letzte " + Wo + " im Jahr.\n");
		}
	}

	static void geburtstag(int month, int day) {
		LocalDate today = LocalDate.now();
		LocalDate bday = LocalDate.of(today.getYear(), month, day);
		Period time = Period.between(today, bday);
		if (time.getDays() < 0 || time.getMonths() < 0) {
			bday = bday.plusYears(1);
			time = Period.between(today, bday);
		}
		System.out.println("Du hast in " + time.getMonths() + " Monaten und " + time.getDays() + " Tagen Geburtstag.");
	}

	static void wochentagSeit(int year, DayOfWeek owo) {
		int zaehler = 0;
		LocalDate today = LocalDate.now();
		LocalDate past = LocalDate.of(year,1,1);
		while(today.getYear()>=past.getYear()) {
			
			if (past.getDayOfWeek().equals(owo)) {
				zaehler++;
			}
			past=past.plusDays(1);
		}
		System.out.println("Von "+year+" bis heute gibt es "+zaehler+" "+owo+"(s).\n");
	}
}
