package Calculator.View;

import java.util.Arrays;
import java.util.Scanner;

import Calculator.Model.Number;

public class InputView {
    private static final String DELIMITER = " ";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] getAlgebra() {
        System.out.println("계산할 수식을 입력하세요.");
        String algebra = SCANNER.nextLine();

        try {
            return getParsedAlgebra(algebra);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAlgebra();
        }

    }

    private static String[] getParsedAlgebra(String algebra) {
        if (algebra == null || algebra.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        String[] parsedAlgebra = algebra.split(DELIMITER);

//        if (!isValidAlgebra(parsedAlgebra)) {
//            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
//        }

        return parsedAlgebra;
    }

//    public static boolean isValidAlgebra(String[] parsedAlgebra) {
//        boolean isPassed = true;
//        for (String parsed : parsedAlgebra) {
//            isPassed = isPassed && (Number.isNumeric(parsed) || isOperator(parsed));
//        }
//
//        return isPassed;
//    }

    private static final String[] OPERATORS = {"+", "-", "*", "/"};
    public static boolean isOperator(String input) {
        return Arrays.asList(OPERATORS).contains(input);
    }


}
