package lotto.application;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int purchase() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public int manualLottoQuantity() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public Deque<String> manualLottos(int count) {
        SCANNER.nextLine();
        System.out.println();
        if (count != 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        return IntStream.range(0, count)
            .mapToObj(__ -> SCANNER.nextLine())
            .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public String winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
