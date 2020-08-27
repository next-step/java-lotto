package nextstep.lotto.view;

import nextstep.lotto.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_MINIMUM_AMOUNT_FOR_BUY;
import static nextstep.lotto.constant.PrintMessage.*;

public class InputView {

    private final int MINIMUM_BUY_AMOUNT = 1000;

    public int inputTotalAmountForBuy() {
        System.out.println(QUESTION_TEXT_BUY_TOTAL_AMOUNT);
        Scanner scanner = new Scanner(System.in);
        int totalAmount = scanner.nextInt();

        if (totalAmount < MINIMUM_BUY_AMOUNT) {
            throw new RuntimeException(INVALID_INPUT_MINIMUM_AMOUNT_FOR_BUY);
        }

        return totalAmount;
    }

    public List<String> inputWinnerNumber() {
        System.out.println(QUESTION_TEXT_LOTTO_WINNER_NUMBER);
        Scanner scanner = new Scanner(System.in);
        String winnerNumber = scanner.nextLine();
        return Arrays.asList(StringUtils.splitString(winnerNumber));
    }

    public int inputBonusNumber() {
        System.out.println(QUESTION_TEXT_LOTTO_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }
}
