package lottoGame;

import java.util.Scanner;

public class Main {

    public static void main(String... arg) {
        LottoGame lottoGame = new LottoGame();

        System.out.println("구입금액을 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        String inputMoney = sc.next();
        lottoGame.buyLotto(inputMoney);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String winningNumbers = sc.next();
        lottoGame.inputWinningNumbers(winningNumbers);

        System.out.println("보너스 볼을 입력해 주세요.");

        String bonusNumber = sc.next();
        lottoGame.inputBonusNumber(bonusNumber);

        lottoGame.run();

        ResultView.showResult(lottoGame);
    }
}
