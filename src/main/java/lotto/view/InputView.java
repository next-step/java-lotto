package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoTicket;
import lotto.model.WinningIdentifier;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MSG = "보너스 볼을 입력해주세요.";
    private static final String DUPLICATED_BONUS_NUMBER_MSG = "이미 당첨 번호에 해당하는 번호입니다.";
    private static Scanner scanner = new Scanner(System.in);

    public static int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MSG);
        return scanner.nextInt();
    }

    public static WinningIdentifier readWinningNumberAndBonusNumber() {
        LottoTicket winningTicket = readWinningNumber();
        LottoNumber bonusNumber = readBonusNumber(winningTicket);
        return new WinningIdentifier(winningTicket, bonusNumber);
    }

    private static LottoTicket readWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MSG);
        return convertToTicket();
    }

    private static LottoNumber readBonusNumber(LottoTicket winningTicket) {
        System.out.println(BONUS_NUMBER_INPUT_MSG);
        return convertToNumber(winningTicket);
    }

    private static LottoTicket convertToTicket() {
        try {
            return LottoTicket.of(scanner.next());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumber();
        }
    }

    private static LottoNumber convertToNumber(LottoTicket winningTicket) {
        try {
            int number = scanner.nextInt();
            validateBonusNumber(winningTicket, number);
            return LottoNumber.of(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winningTicket);
        }
    }

    private static void validateBonusNumber(LottoTicket winningTicket, int number) {
        if (winningTicket.contains(number)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MSG);
        }
    }

}
