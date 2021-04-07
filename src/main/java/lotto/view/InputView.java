package lotto.view;

import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.domain.WinNumbers;
import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private int payMoney;
    private Numbers winNumbers;
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

    public int inputManualGameCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int manualGameCount = scanner.nextInt();
        if (manualGameCount < 0) {
            throw new IllegalArgumentException("로또 수는 0이상의 값을 입력해 주세요.");
        }
        return manualGameCount;
    }

    public List<Numbers> inputManualGameNumbers(int manualGameCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int tempCount = manualGameCount;
        List<Numbers> manualNumbers = new ArrayList<>();
        while (tempCount > 0) {
            manualNumbers.add(splitNumbers(scanner.nextLine()));
            tempCount--;
        }
        return manualNumbers;
    }

    private Numbers splitNumbers(String numbers) {
        String[] splitString = StringUtil.split(",", numbers);
        List<Integer> nos = new ArrayList<>();
        for (String number : splitString) {
            nos.add(Integer.parseInt(number));
        }
        return new Numbers(nos);
    }

    public int getPayMoney() {
        return payMoney;
    }

    public WinNumbers winNumbers() {
        return new WinNumbers(winNumbers, Number.of(bonusNumber));
    }
}
