package lotto.ui;

import lotto.common.ConstantSet;
import lotto.exception.InvalidNumberInputException;

import java.util.Scanner;
import java.util.regex.Matcher;
import static lotto.common.ConstantSet.CUSTOM_MONEY_PATTERN;
import static lotto.common.ConstantSet.CUSTOM_MONEY_REGEXP;
public class InputHandler {
    private Scanner scanner;
    private InputHandler(){
        this.scanner = new Scanner(System.in);
    }
    public static InputHandler of(){
        return new InputHandler();
    }

    public int inputMoney(){
        System.out.println("구입 금액을 입력해주세요.");
        String input = scanner.nextLine();
        Matcher matcher = CUSTOM_MONEY_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidNumberInputException();
        }
        return Integer.parseInt(input);
    }

    public String inputWinnerNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int inputBonusNumber(){
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}
