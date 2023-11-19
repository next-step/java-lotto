package calculator;

public class CalculatorApplication {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.print("계산기 실행 결과: ");
		System.out.println(calculator.run("1 + 2"));
	}
}
