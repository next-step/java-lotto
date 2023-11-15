package calculator;

import calculator.domain.Calculator;
import calculator.domain.Seperator;
import calculator.view.View;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        Calculator calculator = new Calculator();

        //계산식 입력
        String input = view.getString();

        //입력 문자열 분리 & 계산
        Integer result = calculator.calculation(new Seperator().split(input));

        //결과 출력
        view.printResult(result);
    }
}
