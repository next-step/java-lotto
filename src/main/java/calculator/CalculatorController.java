package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalculatorController {

    private Scanner scanner = new Scanner(System.in);
    private CalculatorService calculatorService = new CalculatorService();

    public void start() {
        System.out.println("계산식을 입력해주세요.");
        String input = scanner.nextLine();
        Validator.validateInputNullOrEmpty(input);
        List<String> inputs = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        int result = calculatorService.start(inputs);
        System.out.println(result);
    }

}
