import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		CalculatorController controller = new CalculatorController(new Calculator());
		controller.main();
	}
}
