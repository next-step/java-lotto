package step3.view;

import step3.domain.BonusBall;
import step3.domain.WinLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public int askTotalPrice() {
        System.out.println("구입금액을 입력해 주세요");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public WinLotto askWinnerLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        WinLotto winLotto = new WinLotto(scanner.nextLine());
        return winLotto;
    }

    public BonusBall askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        scanner = new Scanner(System.in);
        BonusBall bonusBall = new BonusBall(scanner.nextInt());
        return bonusBall;
    }

}
