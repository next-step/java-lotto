package lottoAuto.view;

import lottoAuto.model.Lotto;
import lottoAuto.model.LottoAutoInputService;

import java.util.Scanner;

public class LottoAutoInputView {
    private Scanner scanner = new Scanner(System.in);
    protected LottoAutoInputService lottoAutoInputService = new LottoAutoInputService();
    private static final int LOTTO_PRICE = 1000;

    public int inputPrice() {
        int price = scanner.nextInt();
        int amount = price / LOTTO_PRICE;
        return amount;
    }

    public Lotto inputWinningNumber() {
        String winningNumber_string = scanner.next();

        Lotto winningLotto = lottoAutoInputService.inputWinningNumber(winningNumber_string);

        return winningLotto;
    }

    public int inputBonusBall() {
        int bonusBall = scanner.nextInt();

        return bonusBall;
    }
}
