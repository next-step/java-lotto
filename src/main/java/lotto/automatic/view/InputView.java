package lotto.automatic.view;

import lotto.automatic.dto.LottoBuyingMoney;
import lotto.automatic.dto.LottoWinningNums;

import java.util.Scanner;

public class InputView {

    public LottoBuyingMoney getLottoMoney() {

        int money = getInt("구입 금앱을 입력해주세요");
        return new LottoBuyingMoney(money);
    }

    public LottoWinningNums getWinningLottoNums() {

        String rawNumberString = getString("지난 주 당첨 번호를 입력해 주세요.");
        int bonusNumber = getInt("보너스 볼을 입력해주세요.");

        return new LottoWinningNums(rawNumberString, bonusNumber);
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
