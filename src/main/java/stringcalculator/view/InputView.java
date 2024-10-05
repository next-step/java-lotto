package stringcalculator.view;

import stringcalculator.exception.StringCalculatorIllegalArgumentException;
import stringcalculator.util.StringUtil;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String getInputsFromUser() {
        System.out.println("값을 입력하세요. ex) 1 + 2 * 3 / 3");

        String input = scanner.nextLine();

        if(StringUtil.isBlank(input)){
            throw StringCalculatorIllegalArgumentException.INVALID_EMPTY_INPUT;
        }

        return input;

    }
}
