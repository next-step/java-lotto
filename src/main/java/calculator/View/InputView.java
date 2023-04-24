package calculator.View;

import calculator.Enums.Operator;
import calculator.Model.CalculatorElements;
import calculator.Model.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = " ";

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final List<Number> number = new ArrayList<>();
    private static final List<Operator> operator = new ArrayList<>();

    public static CalculatorElements algebra() {
        System.out.println("계산할 수식을 입력하세요.");
        String algebra = SCANNER.nextLine();

        try {
            String[] parsedAlgebra = splitAlgebra(algebra);
            makeCalculatorElements(parsedAlgebra);
            return new CalculatorElements(number, operator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return algebra();
        }
    }

    private static String[] splitAlgebra(String algebra) {
        if (algebra == null || algebra.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        return algebra.split(DELIMITER);
    }

    private static void makeCalculatorElements(String[] parsedAlgebra) {
        for (String element : parsedAlgebra) {
            addElements(element);
        }
    }

    private static void addElements(String element) {
        if (Number.isNumeric(element)) {
            number.add(new Number(element));
            return;
        }

        operator.add(Operator.of(element));
    }
}
