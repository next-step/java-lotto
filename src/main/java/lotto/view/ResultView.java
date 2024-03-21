package lotto.view;

import java.util.Scanner;

public class ResultView {

    private static final String ANSWER_GAME_COUNT = "개를 구매했습니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void gameCount(int gameCount) {
        System.out.println(gameCount +ANSWER_GAME_COUNT);
    }
}
