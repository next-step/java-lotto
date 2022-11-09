package calculator.view;

import calculator.util.StringUtil;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StringUtil stringUtil = new StringUtil();

    public InputView() {
    }

    public String getInput(){
        String inputString = scanner.next();
        stringUtil.checkNullOrEmpty(inputString);
        return inputString;
    }

}
