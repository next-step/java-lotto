package edu.nextstep.lotto.step2.view;

import edu.nextstep.lotto.common.BusinessException;
import edu.nextstep.lotto.step2.error.LottoError;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmount() {
        System.out.println(ViewMessage.Input.QUESTION_PURCHASE_AMOUNT);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new BusinessException(LottoError.INVALID_VALUE_NOT_NUMBER_FORMAT);
        }
    }

    public String getWinningNumber() {
        System.out.println(ViewMessage.Input.QUESTION_WINNING_NUMBERS);
        return scanner.nextLine();
    }
}
