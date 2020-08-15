package pluscalculator.input;

import java.util.Scanner;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import pluscalculator.argument.CalculatorArguments;
import pluscalculator.util.InputAnalyzer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static CalculatorArguments input() {
		System.out.println("계산할 내용을 입력해주세요.");
		return InputAnalyzer.analyze(scanner.nextLine());
	}
}
