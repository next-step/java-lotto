package lotto.objects;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
    public static Money inputMoney() {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        return new Money(money);
    }

    public static Lotto inputLastWinningLotto() {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        String[] splitNumbers = numbers.replace(" ", "").split(",");

        Set<Integer> lastWinningNumbers = new HashSet<>();
        for (String number : splitNumbers) {
            lastWinningNumbers.add(Integer.valueOf(number));
        }

        return new Lotto(lastWinningNumbers);
    }

    public static BonusBall inputBonusBall() {
        Scanner scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();

        return new BonusBall(bonusNumber);
    }
}
