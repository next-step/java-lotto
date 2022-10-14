package step1;

import java.util.Scanner;
import step1.domains.CalculateOperator;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("공백으로 구분된 문자열을 입력해주세요. 숫자과 연산자는 차례대로 입력해야 합니다. ex) 1 + 2 / 3");
        CalculateOperator calculateOperator = new CalculateOperator(scanner.nextLine());

        try {
            System.out.println(calculateOperator.calculate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
