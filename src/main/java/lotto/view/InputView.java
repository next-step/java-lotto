package lotto.view;

import lotto.Lotto;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private int money;
    private String winNumbers;
    private String bonusNumber;

    public void getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        this.money = Integer.parseInt(new Scanner(System.in).nextLine());
    }
    public void getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.winNumbers = new Scanner(System.in).nextLine();
    }

    public void getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        this.bonusNumber = new Scanner(System.in).nextLine();
    }

    public int money() {
        return this.money;
    }

    public String winNumbers() {
        return this.winNumbers;
    }

    public String bonusNumber() {
        return this.bonusNumber;
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
