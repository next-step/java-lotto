package lottoAuto.view;

import java.util.Scanner;

public class LottoAutoInputView {
    private Scanner scanner = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1000;

    public int inputPrice() {
        int price = scanner.nextInt();
        int amount = price / LOTTO_PRICE;
        return amount;
    }

    public String inputWinningNumber() {
        String winningLottoString = scanner.next();

        return winningLottoString;
    }

    public int inputBonusBall() {
        int bonusBall = scanner.nextInt();

        return bonusBall;
    }
}
