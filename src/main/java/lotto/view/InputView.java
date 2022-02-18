package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요";
    private static final String WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUSBALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_TICKET_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요";
    private static final String LOTTO_NUMBER_MANUAL_MESSAGE = "수동으로 구매할 번호를 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);


    public InputView() {
    }

    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return SCANNER.nextLine();
    }

    public String inputLottoTicket() {
        System.out.println(LOTTO_TICKET_MESSAGE);
        return SCANNER.nextLine();
    }

    public String inputWinningLottoNumber() {
        System.out.println(WINNING_LOTTO_NUMBER_MESSAGE);
        return SCANNER.nextLine();
    }

    public int inputBonusLottoNumber() {
        System.out.println(BONUSBALL_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public String doInputLotto(int idx) {
        return SCANNER.nextLine();
    }
}
