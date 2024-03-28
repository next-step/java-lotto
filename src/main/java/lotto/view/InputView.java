package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMEITER = ",";
    private static final String INPUT_SEED_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {
    }


    public static int inputSeedMoney() {
        System.out.println(INPUT_SEED_MESSAGE);
        return toInt(scanner.nextLine());
    }

    private static int toInt(String token) {
        return Integer.parseInt(token.trim());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_MESSAGE);

        String input = scanner.nextLine();
        List<String> tokens = List.of(input.split(SPLIT_DELIMEITER));
        List<Integer> winningNumbers = new ArrayList<>();

        for (String token : tokens) {
            winningNumbers.add(toInt(token));
        }

        return winningNumbers;
    }
}
