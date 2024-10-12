package stringcalculator.ui.input;

import stringcalculator.model.Expression;
import java.util.Scanner;

public class ConsoleInputView implements InputView{

    public static final String INIT_MESSAGE = "문자열 입력하세요!";
    private Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Expression getExpression() {
        System.out.println(INIT_MESSAGE);
        String text = scanner.nextLine();

        return Expression.createExpression(text);
    }
}
