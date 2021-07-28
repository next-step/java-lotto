package lotto.view;

import lotto.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_STATEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);

        return changeIntInputValue();
    }

    public static List<LottoNumber> inputWinningNumbers() {
        printStatement(INPUT_WINNING_NUMBERS_STATEMENT);

        return Arrays.stream(readNumbers())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static String[] readNumbers() {
        return scanner.nextLine()
                .split(NUMBER_DELIMITER);
    }

    private static int changeIntInputValue() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

}
