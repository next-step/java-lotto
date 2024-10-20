package step1.view;

import static step1.domain.StringCalculator.*;

import java.util.Scanner;

public class CalculateMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수식을 입력해주세요.");
		String input = scanner.nextLine();
		System.out.println("계산 결과는 다음과 같습니다.");
		System.out.println(calculate(input));
	}
}
