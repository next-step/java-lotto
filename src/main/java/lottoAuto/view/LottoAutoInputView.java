package lottoAuto.view;

import lottoAuto.service.Lotto;
import lottoAuto.service.LottoAutoInputService;

import java.util.List;
import java.util.Scanner;

public class LottoAutoInputView {
    private Scanner scanner = new Scanner(System.in);
    protected LottoAutoInputService lottoAutoInputService = new LottoAutoInputService();

    public int inputPrice() {
        int price = scanner.nextInt();

        int amount = lottoAutoInputService.inputPrice(price);
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
