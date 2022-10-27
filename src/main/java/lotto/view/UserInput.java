package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInput {

    private static final String SEPARATOR = ",";

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = new Scanner(System.in).nextLine();
        return stringToList(input);
    }

    private static List<Integer> stringToList(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(strNumber -> Integer.parseInt(strNumber.trim()))
                .collect(Collectors.toList());
    }
}
