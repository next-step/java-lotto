package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.PurchaseInformation;
import lotto.util.TextParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 사용자의 입력을 처리한다.
 */
public class InputView {
    private static final String MONEY_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static final String PRIZE_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_PRIZE_QUESTION = "보너스 볼을 입력해 주세요.";
    private static final String NUMBER_OF_MANUAL_PURCHASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_QUESTION = "수동으로 구매할 번호를 입력해 주세요.";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public long askMoneyInput() {
        System.out.println(MONEY_AMOUNT_QUESTION);
        return Long.parseLong(scanner.nextLine());
    }

    public List<LottoNumber> askLastPrizeNumber() {
        System.out.println(PRIZE_NUMBER_QUESTION);
        return TextParser.parseToLottoNumbers(scanner.nextLine());
    }

    public int askBonusPrizeNumber() {
        System.out.println(BONUS_PRIZE_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }

    public int askManualPurchaseCount() {
        System.out.println(NUMBER_OF_MANUAL_PURCHASE);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> askManualLottos(PurchaseInformation purchaseInformation) {
        if (purchaseInformation.getManualPurchaseCount() == 0) {
            return new ArrayList<>();
        }
        return getManualLottos(purchaseInformation);
    }

    private List<String> getManualLottos(PurchaseInformation purchaseInformation) {
        final List<String> lottos = new ArrayList<>();
        System.out.println(MANUAL_LOTTO_NUMBER_QUESTION);
        for (int i = 0; i < purchaseInformation.getManualPurchaseCount(); i++) {
            lottos.add(scanner.nextLine());
        }
        return new ArrayList<>(lottos);
    }
}
