package humbledude.lotto.view;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static long getBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public static Set<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return Stream.of(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
    }

}
