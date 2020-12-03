package lotto.automatic.view;

import lotto.automatic.domain.WinningLotto;
import lotto.automatic.dto.LottoBuyingMoneyAndAmount;

import java.util.Scanner;

public class InputView {

    public LottoBuyingMoneyAndAmount getLottoMoneyAndAmount() {

        int money = getInt("구입 금앱을 입력해주세요");
        int manualAmount = getInt("수동으로 구매할 로또 수를 입력해 주세요.");
        return new LottoBuyingMoneyAndAmount(money, manualAmount);
    }

    public WinningLotto getWinningLottoNums() {

        String rawNumberString = getString("지난 주 당첨 번호를 입력해 주세요.");
        int bonusNumber = getInt("보너스 볼을 입력해주세요.");

        return new WinningLotto(rawNumberString, bonusNumber);
    }

    private int getInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }

    private String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
