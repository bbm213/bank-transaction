
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;



public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/ressource/test.txt";
    	
    public static void main(final String[] args) throws IOException {
		    final Path path = Paths.get(RESOURCES);
		    final List<String> lines = Files.readAllLines(path);
		    double total = 0d;
		    for(final String line: lines) {
			    final String[] columns = line.split(",");
			    final double amount =
			    Double.parseDouble(columns[1]);
			    total += amount;
		    }
		    
		    double totalDate = 0d;
		    final DateTimeFormatter DATE_PATTERN =
		    DateTimeFormatter.ofPattern("dd-MM-yyyy");
			    for(final String line: lines) {
			    final String[] columns = line.split(",");
			    final LocalDate date = LocalDate.parse(columns[0],
			    DATE_PATTERN);
				    if(date.getMonth() == Month.JANUARY) {
					    final double amountDate = Double.parseDouble(columns[1]);
					    totalDate += amountDate;
					 }	    
			    }

		    System.out.println("The total for all transactions is " + total);
		    System.out.println("The total for all transactions in January is " + totalDate);
    }
}
