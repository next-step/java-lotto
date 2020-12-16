package com.jaenyeong.mission02.lotto.view;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;

import java.util.List;
import java.util.Scanner;

import static com.jaenyeong.mission02.lotto.util.Parser.parseWinningNumbers;

public class UI {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final String TEXT_REQUIRED_INPUT_BUY_PRICE = "구입금액을 입력해주세요.";
    private static final String TEXT_NUMBER_OF_BUY_GAME = "개를 구매했습니다.";
    private static final String TEXT_ENTER_LAST_WEEK_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String TEXT_WINNING_STATISTICS = "당첨 통계";
    private static final String TEXT_UNDER_BAR = "---------";

    private UI() {
    }

    public static int scanBuyPrice() {
        System.out.println(TEXT_REQUIRED_INPUT_BUY_PRICE);
        return SCAN.nextInt();
    }

    public static void printNumberOfBuyGame(final int buyGame) {
        System.out.println(buyGame + TEXT_NUMBER_OF_BUY_GAME);
    }

    public static void printLotteryNumbers(final List<LotteryGame> game) {
        game.forEach(System.out::println);
        System.out.println();
    }

    public static List<Integer> scanWinningNumbers() {
        System.out.println(TEXT_ENTER_LAST_WEEK_WIN_NUMBERS);
        SCAN.nextLine(); // Parser 클래스에서 stream 사용으로 인하여 삽입
        return parseWinningNumbers(SCAN.nextLine());
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
}
