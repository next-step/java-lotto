package lotto.view;

import lotto.domain.Lotto;

import java.util.*;
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
        Set<Integer> result = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        if (result.size() != Lotto.COUNT) {
            throw new IllegalArgumentException("6개의 서로 다른 당첨 번호가 입력되어야 합니다.");
        }
        return new ArrayList<>(result);
    }

    public static int inputBonusNumber(List<Integer> winNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1개의 보너스 번호가 입력되어야 합니다.");
        }

        if (Lotto.MIN > input || input > Lotto.MAX) {
            throw new IllegalArgumentException("입력 범위를 벗어났습니다.");
        }
        if (winNumbers.contains(input)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야 합니다.");
        }
        return input;
    }
}
