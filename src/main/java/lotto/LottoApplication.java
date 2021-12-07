package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoApplication {
    private static final Scanner scanner = new Scanner(System.in);
    public static final int LOTTO_PRICE = 1000;
    public static final String DELIMITER = ", ";

    public static void main(String[] args) {
        InputView.printPurchaseRequest();

        int purchaseAmount = scanner.nextInt();
        int quantity = quantity(purchaseAmount);

        ResultView.printQuantity(quantity);

        for (int i = 0; i < quantity; i++) {
            LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
            Lotto lotto = Lotto.from(lottoNumbers);
            ResultView.printLottoNumbers(lotto);
        }

        InputView.printWinningNumbersRequest();
        String[] winningNumbers = winningNumbers();
    }

    private static String[] winningNumbers() {
        return scanner.next().split(DELIMITER);
    }

    private static int quantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
