package calculator.ui;

import java.util.Scanner;

public class InputViewImpl implements InputView{
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public String inputExpression() {
        return sc.nextLine();
    }
}
