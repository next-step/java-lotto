package step1;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String BLANK = " ";
    private static final Scanner SCANNER = new Scanner(System.in);
    private final NumberParser numberParser;
    private final OperatorParser operatorParser;
    private String input;

    public InputView(NumberParser numberParser, OperatorParser operatorParser) {
        this.numberParser = numberParser;
        this.operatorParser = operatorParser;
    }

    public List<Integer> getNumbers() {
        return numberParser.parse(input);
    }

    public List<Operator> getOperators() {
        return operatorParser.parse(input);
    }

    public void request() {
        System.out.println("계산식을 입력해주세요.");
        input = SCANNER.nextLine().replaceAll(BLANK, "");
    }
}
