package step3;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String input() {
        return sc.nextLine();
    }

    public static Set<Integer> inputWinningNumber() {
        return changeIntegerList(sc.nextLine());
    }

    private static Set<Integer> changeIntegerList(String input) {
        return Stream.of(input.split(", "))
                .map(InputView::changeInteger)
                .collect(Collectors.toSet());
    }

    private static Integer changeInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자와 콤마만 입력 가능합니다.");
        }
    }
}
