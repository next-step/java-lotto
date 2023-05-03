package lotto.view;

import lotto.domain.Lotto;

import java.util.Scanner;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    private final Scanner scanner = new Scanner(System.in);

    public Long inputPurchasePrice() {
        ResultView.printPurchasePriceInputCommand();

        long purchasePrice = Long.parseLong(nextLine());
        if (isNotInThousands(purchasePrice)) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
        return purchasePrice;
    }

    private boolean isNotInThousands(long purchasePrice) {
        return purchasePrice % LOTTO_PRICE != 0;
    }

    public String inputWinningLotto() {
        ResultView.printWinningLottoInputCommand();

        return nextLine();
    }

    public int inputBonusLottoNumber(Lotto winningLotto) {
        ResultView.printBonusLottoNumberInputCommand();

        int bonusLottoNumber = Integer.parseInt(nextLine());

        if (winningLotto.value().stream().anyMatch(v -> v.value() == bonusLottoNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 일치할 수 없습니다.");
        }
        return bonusLottoNumber;
    }

    private String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }

}
