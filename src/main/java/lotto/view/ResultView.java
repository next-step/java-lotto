package lotto.view;

import java.util.List;

public class ResultView {

    private static final String BUY_COMPLETED_INPUT_TEXT = "%s개를 구매했습니다.";

    public static void printBuyCompleted(String count) {
        System.out.println(String.format(BUY_COMPLETED_INPUT_TEXT, count));
    }

    public static void printLottoList(List<List<Integer>> lottoList) {
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

}
