package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Input {
    private static final String QUESTION_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String QUESTION_FOR_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public Lottos setLottos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_FOR_MONEY);
        int money = scanner.nextInt();

        return new Lottos(money);
    }

    public WinNumbers setWinNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_FOR_WIN_NUMBERS);
        String winNumbersString = scanner.nextLine();
        System.out.println();

        return new WinNumbers(split(winNumbersString));
    }

    private static Set<Integer> split(String WinNumbersString) {
        return Arrays.stream(WinNumbersString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
