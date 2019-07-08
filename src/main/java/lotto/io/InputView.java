package lotto.io;

import lotto.model.Number;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int InputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static LinkedHashSet<Number> inputWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(
                scanner.next()
                        .replace(" ", "")
                        .split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(Number::of)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static Number inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요");
        return Number.of(scanner.nextInt());
    }
}
