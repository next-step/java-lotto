package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요쉼표(,)를 기준으로 구분).");
        return toInteger(splitByComma(SCANNER.next()));
    }

    private static List<Integer> toInteger(List<String> inList) {
        return inList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private static List<String> splitByComma(String input) {
        return new ArrayList(Arrays.asList(input.split(DELIMITER)));
    }

}
