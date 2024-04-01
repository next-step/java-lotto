package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Budget inputBuyBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Budget(SCANNER.nextInt());
    }

    public static WinLotto inputLastWinLotto() {
        return new WinLotto(parseLottoNumbers(), parseBonusNumber());
    }

    private static List<Integer> parseLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        SCANNER.nextLine();
        return parseInts(split(SCANNER.nextLine()));
    }

    private static Integer parseBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private static List<String> split(String input) {
        String[] result = input.split(", ");
        return Arrays.stream(result).collect(Collectors.toList());
    }

    private static List<Integer> parseInts(List<String> input) {
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
