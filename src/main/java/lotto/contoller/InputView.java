package lotto.contoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int purchaseAmountQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
        int value = scanner.nextInt();
        scanner.nextLine();
        System.out.println(value / 1000 + "개를 구매했습니다.");

        return value;
    }

    public List<Integer> findWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String value = scanner.nextLine();

        return Arrays.stream(value.split(", "))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
