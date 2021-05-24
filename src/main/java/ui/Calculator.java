package ui;

public class Calculator {
	private static final CalculatorController calculateController = new CalculatorController ();

	public static void powerOn(){
		calculateController.waitForInput();
	}
}
