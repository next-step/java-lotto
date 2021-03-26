package lotto.view;

import lotto.domain.WinNumbers;
import lotto.util.StringUtil;

import java.util.Scanner;

public class InputView {
    private int payMoney;
    private String[] winNumbers;
    private int bonusNumber;

    public void inputPayMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        this.payMoney = scanner.nextInt();
    }

    public void inputHitNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        this.winNumbers = splitNumbers(scanner.nextLine());
    }

    public void inputHitBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        this.bonusNumber = scanner.nextInt();
    }

    private String[] splitNumbers(String numbers) {
        return StringUtil.split(",", numbers);
    }

    public int getPayMoney() {
        return payMoney;
    }

    public WinNumbers getWinNumbers() {
        return new WinNumbers(winNumbers, bonusNumber);
    }
}
