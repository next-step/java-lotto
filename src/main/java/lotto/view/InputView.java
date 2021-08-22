package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoTicket;
import lotto.model.WinningIdentifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MANUAL_LOTTO_COUNT_INPUT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PURCHASE_MANUAL_LOTTO_NUMBER_INPUT_MSG = "수동으로 구매할 로또 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MSG = "보너스 볼을 입력해주세요.";
    private static final String NUMBER_EXCEPTION_MSG = "숫자를 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MSG);
        try {
            return readNumber();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    public static int readPurchaseManualLottoCount() {
        System.out.println(PURCHASE_MANUAL_LOTTO_COUNT_INPUT_MSG);
        try {
            return readNumber();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return readPurchaseManualLottoCount();
        }
    }

    private static int readNumber() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NUMBER_EXCEPTION_MSG);
        }
    }

    public static List<String> readPurchaseManualLottoNumber(int count) {
        System.out.println(PURCHASE_MANUAL_LOTTO_NUMBER_INPUT_MSG);
        return IntStream.range(0, count)
                .mapToObj(i -> inputManualLottoNumber())
                .collect(Collectors.toList());
    }

    private static String inputManualLottoNumber() {
        return scanner.nextLine();
    }

    public static WinningIdentifier readWinningNumberAndBonusNumber() {
        LottoTicket winningTicket = readWinningNumber();
        return readBonusNumber(winningTicket);
    }

    private static LottoTicket readWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MSG);
        return convertToTicket();
    }

    private static WinningIdentifier readBonusNumber(LottoTicket winningTicket) {
        System.out.println(BONUS_NUMBER_INPUT_MSG);
        LottoNumber bonusNumber = convertToNumber(winningTicket);

        try {
            return new WinningIdentifier(winningTicket, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winningTicket);
        }
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
            return LottoNumber.of(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return convertToNumber(winningTicket);
        }
    }

}
