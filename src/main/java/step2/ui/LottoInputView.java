package step2.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class LottoInputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {
    }

    public static int getBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return SCANNER.nextInt();
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.nextLine();

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }
}
