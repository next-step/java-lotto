package lotto.view;

import lotto.domain.LottoWinningNumbers;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_MANUALLY_PICKED_LOTTOTICKET = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUALLY_PICKED_LOTTOTICKET = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_LOTTOTICKET_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static int purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
        String purchaseAmount = SCANNER.nextLine();
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new LottoException("로또 구입 금액은 숫자로 입력해야 합니다");
        }
    }

    private static int numberOfManuallyPickedLottoTicket() {
        System.out.println(NUMBER_OF_MANUALLY_PICKED_LOTTOTICKET);
        String numberOfManuallyPickedLottoTicket = SCANNER.nextLine();
        try {
            return Integer.parseInt(numberOfManuallyPickedLottoTicket);
        } catch (NumberFormatException e) {
            throw new LottoException("수동으로 구매할 로또 수는 숫자로 입력해야 합니다");
        }
    }

    public static List<String> manuallyPickedLottoTicket() {
        int number = numberOfManuallyPickedLottoTicket();
        if (number == 0) {
            return new ArrayList<>();
        }
        System.out.println(MANUALLY_PICKED_LOTTOTICKET);
        List<String> manuallyPickedLottoTicket = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String input = SCANNER.nextLine();
            manuallyPickedLottoTicket.add(input);
        }
        return manuallyPickedLottoTicket;
    }

    public static LottoWinningNumbers inputLottoWinningNumbers() {
        return LottoWinningNumbers.from(winningLottoTicketNumber(), bonusNumber());

    }

    private static String winningLottoTicketNumber() {
        System.out.println(WINNING_LOTTOTICKET_NUMBERS);
        return SCANNER.nextLine();
    }

    private static String bonusNumber() {
        System.out.println(BONUS_NUMBER);
        return SCANNER.nextLine();
    }

}
