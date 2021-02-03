package lotto.view;

import lotto.domain.LottoTicket;
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
        Integer price = Integer.valueOf(input);
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
            Integer winningNumber = Integer.valueOf(winningNumberExceptBlank);
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
        Integer bonusNumber = Integer.valueOf(input);
        return bonusNumber;
    }

    public static int inputNumberOfManualLottoTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = scanner.next();
        InputValidator.checkNumberValidation(input);
        Integer NumOfManualLottoTicket = Integer.valueOf(input);
        return NumOfManualLottoTicket;
    }

    public static List<Integer> inputManualLottoTicketPickedNumber() {
        List<Integer> pickedNumbers = new ArrayList<>();
        String input = scanner.next();
        for (String s : input.split(",")) {
            pickedNumbers.add(Integer.valueOf(s));
        }
        return pickedNumbers;
    }
}