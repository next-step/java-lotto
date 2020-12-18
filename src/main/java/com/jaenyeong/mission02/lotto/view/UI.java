package com.jaenyeong.mission02.lotto.view;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.jaenyeong.mission02.lotto.util.Parser.parseWinningNumbers;

public class UI {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final String TEXT_REQUIRED_INPUT_BUY_PRICE = "구입금액을 입력해주세요.";
    private static final String TEXT_ENTER_LAST_WEEK_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String TEXT_WINNING_STATISTICS = "당첨 통계";
    private static final String TEXT_UNDER_BAR = "---------";
    private static final String TEXT_INPUT_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
    private static final String TEXT_INPUT_NUMBER_OF_BUY_MANUAL_GAME = "수동으로 구매할 로또 수를 입력해주세요";
    private static final String TEXT_INPUT_NUMBERS_OF_MANUAL_LOTTERY_GAME = "수동으로 구매할 번호를 입력해 주세요.";

    private UI() {
    }

    public static int scanBuyPrice() {
        System.out.println(TEXT_REQUIRED_INPUT_BUY_PRICE);
        return SCAN.nextInt();
    }

    public static void printLotteryNumbers(final List<LotteryGame> game) {
        game.forEach(System.out::println);
        System.out.println();
    }

    public static List<Integer> scanWinningNumbers() {
        System.out.println(TEXT_ENTER_LAST_WEEK_WIN_NUMBERS);
        return parseWinningNumbers(SCAN.nextLine());
    }

    public static int scanBonusNumbers() {
        System.out.println(TEXT_INPUT_BONUS_NUMBER);
        return SCAN.nextInt();
    }

    public static void printResultStatistics(final List<String> winningStatistics) {
        System.out.println();
        System.out.println(TEXT_WINNING_STATISTICS);
        System.out.println(TEXT_UNDER_BAR);
        winningStatistics.forEach(System.out::println);
    }

    public static void printPrize(final String textPrize) {
        System.out.println(textPrize);
    }

    public static int getInputNumberOfManual() {
        System.out.println();
        System.out.println(TEXT_INPUT_NUMBER_OF_BUY_MANUAL_GAME);
        return SCAN.nextInt();
    }

    public static List<List<Integer>> scanManualNumbers(final int numberOfInput) {
        System.out.println();
        System.out.println(TEXT_INPUT_NUMBERS_OF_MANUAL_LOTTERY_GAME);
        SCAN.nextLine();

        final List<List<Integer>> givenNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfInput; i++) {
            givenNumbers.add(parseWinningNumbers(SCAN.nextLine()));
        }

        return givenNumbers;
    }
}
