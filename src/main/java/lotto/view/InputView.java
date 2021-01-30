package lotto.view;

import lotto.utils.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.next();

        InputValidator.checkNumberValidation(input);
        int price = Integer.parseInt(input);
        InputValidator.checkPriceValidation(price);
        return price;
    }

    public static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersInput = scanner.next();
        for (String input : winningNumbersInput.split(",")) {
            String winningNumberExceptBlank = input.trim();
            InputValidator.checkNumberValidation(winningNumberExceptBlank);
            int winningNumber = Integer.parseInt(winningNumberExceptBlank);
            InputValidator.checkLottoNumberValidation(winningNumber);
            winningNumbers.add(winningNumber);
        }
        InputValidator.checkLengthWinningNumbersValidation(winningNumbers.size());
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.next();
        InputValidator.checkNumberValidation(input);
        return Integer.parseInt(input);
    }
}
