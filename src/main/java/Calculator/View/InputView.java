package Calculator.View;

import java.util.Scanner;
import Util.CheckInput;

public class InputView {
    private static final String DELIMITER = " ";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] getAlgebra() {
        System.out.println("계산할 수식을 입력하세요.");
        String algebra = SCANNER.nextLine();

        try {
            return getParsedAlgebra(algebra,DELIMITER);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAlgebra();
        }

    }

    private static String[] getParsedAlgebra(String algebra, String Delimiter) {
        if (algebra == null || algebra.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        String[] parsedAlgebra = algebra.split(Delimiter);

        if (!isValidAlgebra(parsedAlgebra)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }

        return parsedAlgebra;
    }

    public static boolean isValidAlgebra(String[] parsedAlgebra) {
        boolean isPassed = true;


        try {
            for (String parsed: parsedAlgebra){
                isPassed = isPassed && (CheckInput.isNumeric(parsed) || CheckInput.isOperator(parsed));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return isPassed;
    }


}
