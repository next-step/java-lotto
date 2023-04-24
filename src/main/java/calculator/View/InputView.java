package calculator.View;

import java.util.Scanner;

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

        return algebra.split(DELIMITER);
    }
}
