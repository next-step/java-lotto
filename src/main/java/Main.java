import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputExpression = scanner.nextLine();
		if(inputExpression.isBlank()) {
			throw new IllegalArgumentException("유효한 계산식을 입력해주세요");
		}

		String[] inputs = inputExpression.split(" ");
	}
}
