package lottoGame.view;

import lottoGame.InputException;
import lottoGame.model.InputParameter;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Pattern filter = Pattern.compile("^([0-9]+)$");

    public static InputParameter print() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = scanner.next();
        validateInput(amount);
        return new InputParameter(Integer.parseInt(amount));
    }

    private static void validateInput(String amount) {
        if (!filter.matcher(amount).matches()) {
            throw new InputException("숫자만 입력해주세요.");
        }
    }
}
