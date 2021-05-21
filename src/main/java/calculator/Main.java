package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("더하고자 하는 문자열을 입력해주세요.");
		String userInput = sc.nextLine();
		CalculatorModel model = new CalculatorModel(userInput);
		model.execute();
	}
}
