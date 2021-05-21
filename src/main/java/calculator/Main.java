package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		AddCalculatorModel model = new AddCalculatorModel(userInput);
		System.out.println(model.execute());
	}
}
