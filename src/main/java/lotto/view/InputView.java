package lotto.view;

import lotto.constant.Question;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int priceScan() {
        System.out.println(Question.PRICE.getQuestion());
        return scanner.nextInt();
    }

    public static String[] lastWeekLottoNumbers() {
        System.out.println(Question.LAST_WEEK_LOTTO_NUMBER.getQuestion());
        return scanner.nextLine().split(",");
    }
}
