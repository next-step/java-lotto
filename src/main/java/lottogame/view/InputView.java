package lottogame.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    public static final String REQUEST_MONEY = "구입금액을 입력해주세요.";
    public static final String REQUEST_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";

    public static int requestMoney() {
        System.out.println(REQUEST_MONEY);
        return Integer.parseInt(inputValue());
    }

    public static List<Integer> requestWinningLotto() {
        System.out.println(REQUEST_WINNING_LOTTO);
        return Stream.of(inputValue().split(","))
                .map((string) -> Integer.parseInt(string.trim()))
                .collect(Collectors.toList());
    }

    private static String inputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
