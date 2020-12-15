package lotto.ui;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int scanBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static Set<Integer> scanWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();

        return Arrays.stream(input.split(","))
                .map(Integer::new)
                .limit(Lotto.LOTTO_NUMBER_SIZE)
                .collect(Collectors.toSet());
    }
}
