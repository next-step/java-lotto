package lotto.view;

import lotto.domain.Budget;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Budget inputBuyBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        Budget budget = new Budget(SCANNER.nextInt());
        System.out.println(budget.canBuyQuantity() + "개를 구매했습니다.");
        return budget;
    }

    public static Lotto inputLastWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        SCANNER.nextLine();
        return Lotto.ofNumbers(parseInts(split(SCANNER.nextLine())));
    }

    private static List<String> split(String input) {
        String[] result = input.split(", ");
        return Arrays.stream(result).collect(Collectors.toList());
    }

    private static List<Integer> parseInts(List<String> input) {
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
