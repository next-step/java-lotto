package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.util.InputUtil;

import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String MANUAL_LOTTO_TICKET_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해주세요";
    private static final long PRICE_PER_TICKET = 1_000L;
    private static final Scanner scanner = new Scanner(System.in);


    public Money readMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return InputUtil.readMoney(readInput());
    }

    public Set<LottoNumber> readLottoNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return InputUtil.readLottoNumbers(readInput());
    }

    public LottoNumber readBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return InputUtil.readBonusNumber(readInput());
    }

    private static String readInput() {
        return scanner.nextLine();
    }

    public Money readManualTicketPrice() {
        System.out.println(MANUAL_LOTTO_TICKET_COUNT_MESSAGE);
        long manualLottoCount = InputUtil.parseLong(readInput());
        return new Money(manualLottoCount * PRICE_PER_TICKET);
    }
}
