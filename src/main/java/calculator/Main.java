package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 덧셈 계산기 시작");
		System.out.println("쉼표(,) 또는 콜롬(:) 외 구분자를 지정하고 싶다면 아래 입력해주시기 바랍니다.(Default: ',',':') ");
		System.out.println("//;\\n1;2;3 구분자 입력하기");
		String delimiter = sc.next();
		if (delimiter.length() != 1){
			throw new RuntimeException("구분자가 유효하지 않습니다.");
		}
		System.out.println("더하고자 하는 문자열을 입력해주세요.");
		String userInput = sc.nextLine();
		CalculatorModel model = new CalculatorModel(userInput);
		model.execute();
	}
}
