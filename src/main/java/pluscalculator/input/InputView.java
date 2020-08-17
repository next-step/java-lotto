package pluscalculator.input;

import java.util.Scanner;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static String input() {
		System.out.println("계산할 내용을 입력해주세요.");
		return scanner.nextLine();
	}
}
