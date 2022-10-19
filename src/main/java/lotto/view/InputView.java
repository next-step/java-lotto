package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price = scanner.nextInt();
        if (price <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다");
        }
        return price;
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.next();
        List<Integer> result = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (result.stream().distinct().count() != Lotto.COUNT) {
            throw new IllegalArgumentException("6개의 서로 다른 당첨 번호가 입력되어야 합니다.");
        }
        return result;
    }
}
