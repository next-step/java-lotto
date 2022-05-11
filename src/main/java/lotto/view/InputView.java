package lotto.view;

import lotto.domain.WinningNumbers;
import lotto.util.InputUtils;

import java.util.List;

public class InputView {
    private static final int EACH_PRICE = 1000;
    private static final int BASE_PRICE = 0;

    public static int inputPurchaseAmount() {
        int purchasePrice = InputUtils.scanNumber("구매금액을 입력해 주세요.");

        if (purchasePrice < EACH_PRICE) {
            throw new IllegalArgumentException("로또 구매를 위해서는 천원 이상 입력해야 합니다.");
        }

        if (purchasePrice % EACH_PRICE != BASE_PRICE) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }

        return printPurchaseAmount(purchasePrice / EACH_PRICE);
    }

    private static int printPurchaseAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
        return amount;
    }


    public static List<Integer> inputWinningNumbers() {
        String winningNumbers = InputUtils.scan("지난 주 당첨 번호를 입력해 주세요.");
        return WinningNumbers.get(winningNumbers);
    }
}
