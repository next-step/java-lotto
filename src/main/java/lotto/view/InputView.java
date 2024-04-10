package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_MONEY = "구입금액을 입력해주세요.";
    private static final String REQUEST_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public int getMoneyInput() {
        System.out.println(REQUEST_MONEY);
        return scanner.nextInt();
    }

    public static List<Integer> getWinningLottoInput() {
        System.out.println(REQUEST_WINNING_LOTTO);
        return Stream.of(inputValue().split(","))
                .map((string) -> Integer.parseInt(string.trim()))
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return scanner.nextInt();
    }

    private static String inputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
