package calculator;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IntegrateTest {
    @Test
    void integrateTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("식을 입력하세요");
        String input = scanner.nextLine();
        UserInput userInput = new UserInput(input);
        int result = StringCalculator.calculate(userInput.getInput());
        System.out.println("결과값 : " + result);
        assertThat(result).isEqualTo(10);
    }
}
