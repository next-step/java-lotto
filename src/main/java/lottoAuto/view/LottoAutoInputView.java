package lottoAuto.view;

import lottoAuto.service.LottoAutoResultService;

import java.util.List;
import java.util.Scanner;

public class LottoAutoInputView {
    private Scanner scanner = new Scanner(System.in);
    protected LottoAutoResultService lottoAutoResultService = new LottoAutoResultService();

    public void inputPrice() {
        int price = scanner.nextInt();

        lottoAutoResultService.inputPrice(price);

    }

    public List<Integer> inputWinningNumber() {
        String winningNumber_string = scanner.next();

        List<Integer> winningNumber = lottoAutoResultService.inputWinningNumber(winningNumber_string);

        return winningNumber;
    }

    public int inputBonusBall() {
        int bonusBall = scanner.nextInt();

        return bonusBall;
    }
}
