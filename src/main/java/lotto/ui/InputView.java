package lotto.ui;

import lotto.objects.Lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    public int enterPurchaseMoney() {
        System.out.println("구입금액을 입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();

        return money;
    }

    public Lotto enterLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        String[] splitNumbers = numbers.replace(" ", "").split(",");

        Set<Integer> lastWinningNumbers = new HashSet<>();
        for (String number : splitNumbers) {
            lastWinningNumbers.add(Integer.valueOf(number));
        }

        Lotto lastWinningLotto = new Lotto(lastWinningNumbers);

//        for (String number : splitNumbers) {
//            lastWinningLotto.addNumber(Integer.valueOf(number));
//        }

        return lastWinningLotto;
    }

    public int enterBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();

        return bonusNumber;
    }
}
