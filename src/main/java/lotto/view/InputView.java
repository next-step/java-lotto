package lotto.view;

import lotto.utils.PreConditionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_TICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL = "보너스 볼을 입력해 주세요.";

    public String purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
        String purchaseAmount = scanner.nextLine().trim();
        PreConditionUtil.checkNullOrEmpty(purchaseAmount);
        return purchaseAmount;
    }

    public String manualLottoTicketCount() {
        System.out.println();
        System.out.println(MANUAL_LOTTO_TICKET_COUNT);
        String manualLottoTicketCount = scanner.nextLine().trim();
        PreConditionUtil.checkNullOrEmpty(manualLottoTicketCount);
        return manualLottoTicketCount;
    }

    public void manualLottoNumberPhrase() {
        System.out.println();
        System.out.println(MANUAL_LOTTO_NUMBERS);
    }

    public List<String> manualLottoNumbers(int manualNumberOfTicket) {
        List<String> manualLottoNumbers = new ArrayList<>();

        for (int i = 0; i < manualNumberOfTicket; i++) {
            String lottoNumbers = scanner.nextLine().trim();
            PreConditionUtil.checkNullOrEmpty(lottoNumbers);
            manualLottoNumbers.add(lottoNumbers);
        }
        return manualLottoNumbers;
    }

    public String winningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS);
        String winningNumbers = scanner.nextLine().trim();
        PreConditionUtil.checkNullOrEmpty(winningNumbers);
        return winningNumbers;
    }

    public String bonusBall() {
        System.out.println();
        System.out.println(BONUS_BALL);
        String bonusBall = scanner.nextLine().trim();
        PreConditionUtil.checkNullOrEmpty(bonusBall);
        return bonusBall;
    }
}
