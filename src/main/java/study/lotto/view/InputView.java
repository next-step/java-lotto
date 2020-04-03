package study.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String CUSTOM_NUMBER_COUNT_MESSAGE =
            "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String CUSTOM_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";


    public static int getAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(AMOUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = scanner.nextLine();
        return parseInputToList(input);
    }

    public static int getBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public static List<List<Integer>> getCustomNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CUSTOM_NUMBER_COUNT_MESSAGE);
        int customNumberCount = scanner.nextInt();
        if (customNumberCount > 0) {
            return getCustomNumberDetail(customNumberCount);
        }
        return null;
    }

    public static List<List<Integer>> getCustomNumberDetail(
            int customNumberCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CUSTOM_NUMBER_MESSAGE);
        List<List<Integer>> customNumberList = new ArrayList<>();
        for (int i = 0; i < customNumberCount; i++) {
            String input = scanner.nextLine();
            customNumberList.add(parseInputToList(input));
        }

        return customNumberList;
    }

    private static List<Integer> parseInputToList(String input) {
        return Arrays.stream(input.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }

    private InputView() {
    }
}
