package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddCalculatorModel model = new AddCalculatorModel();
		System.out.println(model.execute(sc.nextLine()));
	}
}
