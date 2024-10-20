package step1.view;

import static step1.domain.StringCalculator.*;

import java.util.Scanner;

import step1.exception.CommonInputException;
import step1.exception.DivideZeroException;

public class CalculateMain {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("수식을 입력해주세요.");
			String input = scanner.nextLine();
			int result = calculate(input);
			System.out.println("계산 결과는 다음과 같습니다.");
			System.out.println(result);
		} catch (CommonInputException | DivideZeroException e) {
			System.out.println(e.getMessage());
		}
	}
}
