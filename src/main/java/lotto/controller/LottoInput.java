package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    static Scanner scanner = new Scanner(System.in);

    private LottoInput() {

    }

    public static int getInput() {
        System.out.println("구입금액을 입력하세요.");
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
