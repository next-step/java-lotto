package lotto.view;

import lotto.constant.Question;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);


    public int priceScan() {
        System.out.println(Question.PRICE.getQuestion());
        return scanner.nextInt();
    }

    public String[] lastWeekLottoNumbersScan() {
        scanner.nextLine();
        System.out.println(Question.LAST_WEEK_LOTTO_NUMBER.getQuestion());
        return scanner.nextLine().split(",");
    }

    public int bonusNumberScan() {
        System.out.println(Question.BONUS_NUMBER.getQuestion());
        return scanner.nextInt();
    }
}
