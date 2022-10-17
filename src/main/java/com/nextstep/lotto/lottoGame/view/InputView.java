package com.nextstep.lotto.lottoGame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int getBudget() {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> getLottoNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(",");
        return Arrays.stream(numbers)
                .map(n -> toUnsignedInteger(n))
                .collect(Collectors.toList());
    }

    private static int toUnsignedInteger(String numericString) {
        try {
            return Integer.parseUnsignedInt(numericString.replaceAll("\\s",""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
