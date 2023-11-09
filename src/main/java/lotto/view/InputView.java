package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String REGEX = ", ";

    public static int input(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        int input = scanner.nextInt();
        scanner.nextLine();

        return input;
    }

    public static List<Integer> winnerNumber(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        for(String number : input.split(REGEX)) {
            numbers.add(Integer.valueOf(number));
        }

        return numbers;
    }
}
