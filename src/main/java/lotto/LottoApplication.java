package lotto;

import lotto.view.InputView;

import java.util.Scanner;

public class LottoApplication {
    private static final Scanner scanner = new Scanner(System.in);
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        InputView.printPurchaseRequest();

        int purchaseAmount = scanner.nextInt();
        int quantity = quantity(purchaseAmount);

        InputView.printQuantity(quantity);

        for (int i = 0; i < quantity; i++) {
            LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
            Lotto lotto = Lotto.from(lottoNumbers);
            InputView.printLottoNumbers(lotto);
        }
    }

    private static int quantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
