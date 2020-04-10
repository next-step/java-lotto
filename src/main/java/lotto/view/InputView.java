package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String ESCAPED_NEWLINE = "\\n";
    private static final String CHARACTER_NEWLINE = "\n";

    private final String formula;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        formula = inputFormula(scanner).replace(ESCAPED_NEWLINE, CHARACTER_NEWLINE);
    }

    private String inputFormula(final Scanner scanner) {
        System.out.println("==============================================");
        System.out.println(" * 기본 구분자 : 쉼표(,), 콜론(:)");
        System.out.println(" * 커스텀 구분자 : // 와 \\n 사이에 입력");
        System.out.println("==============================================");
        System.out.println("계산할 문자열을 입력하세요.");
        return scanner.nextLine();
    }

    public String getFormula() {
        return formula;
    }
}
