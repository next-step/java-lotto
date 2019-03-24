package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.WinningLotto;

import java.util.Scanner;

public class InputView {

    public static LottoMoney inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoMoney(scanner.nextInt());
    }

    public static WinningLotto inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumbers = scanner.nextLine().split(", ");

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.next();
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
