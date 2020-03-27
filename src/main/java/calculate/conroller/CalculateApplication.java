package calculate.conroller;

import calculate.domain.Calculator;
import calculate.view.InputView;

import java.util.Scanner;

public class CalculateApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산할 구분자와 문자열을 입력 하세요");

        String input = sc.nextLine();
        System.out.println(input);
        InputView inputView = new InputView(input);

        Calculator calculator = new Calculator(inputView.getOperandString(), inputView.getDelimiter());
        int result = calculator.calculate();

        System.out.println(result);
    }
}
