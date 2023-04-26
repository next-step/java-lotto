package lotto.view;

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

    public String inputWinningLottoNumbers() {
        ResultView.printWinningLottoNumberInputCommand();

        return nextLine();
    }

    private String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }

}
