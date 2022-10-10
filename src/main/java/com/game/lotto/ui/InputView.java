package com.game.lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WINNER_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String TICKET_NUMBER_STRING_INPUT_SEPARATOR = ",";

    public static int inputPrice() {
        return inputNumber(INPUT_PRICE_MESSAGE);
    }

    public static List<Integer> inputLastWinnerNumber() {
        String inputString = inputString(INPUT_LAST_WINNER_NUMBER_MESSAGE);
        return Arrays.stream(inputString.split(TICKET_NUMBER_STRING_INPUT_SEPARATOR))
                .mapToInt(x -> Integer.parseInt(x.trim()))
                .boxed()
                .collect(Collectors.toUnmodifiableList());
    }

    public static int inputNumber(String inputMessage) {
        System.out.println(inputMessage);
        return new Scanner(System.in).nextInt();
    }

    public static String inputString(String inputMessage) {
        System.out.println(inputMessage);
        return new Scanner(System.in).nextLine();
    }
}
