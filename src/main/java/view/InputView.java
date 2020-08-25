package view;

import domain.Lotto;
import domain.Number;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Set<Number> getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String str = scanner.nextLine();
        return getWinningListFromString(str);
    }

    public static Number getBonusNumber(Lotto lottoWinningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        String s = scanner.nextLine();
        Number bonusNumber = new Number(Integer.parseInt(s));
        boolean isExist = lottoWinningNumbers.isContainBonus(bonusNumber);
        if (isExist) {
            throw new IllegalArgumentException("보너스 번호는 로또 숫자와 중복되면 안 됩니다");
        }
        return bonusNumber;
    }

    private static Set<Number> getWinningListFromString(String winningNumberStr) {
        return Arrays.stream(winningNumberStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}