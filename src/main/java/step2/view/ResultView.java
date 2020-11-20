package step2.view;

import java.util.HashMap;
import java.util.List;


public class ResultView {
    private static final String RESULT_MESSAGE = "당첨통계";
    private static final String BELOW_LINE = "--------";
    private static final int MIN_MATCH_NUMBER = 3;
    private static final String FOURTH_PRIZE_MESSAGE = "3개 일치 (5000원)- ";
    private static final int FOUR_MATCH_NUMBER = 4;
    private static final String THIRD_PRIZE_MESSAGE = "4개 일치 (50000원)- ";
    private static final int FIVE_MATCH_NUMBER = 5;
    private static final String SECOND_PRIZE_MESSAGE = "5개 일치 (1500000원)- ";
    private static final int MAX_MATCH_NUMBER = 6;
    private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2000000000원)- ";
    private static final String PIECE = "개";
    private static final String TOTAL_RETURN_MESSAGE = "총 수익률은 ";
    private static final String IS = "입니다.";

    public static void printNumberOfLotto(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }


    public static void printWinningResult(HashMap<Integer, Integer> hashMap) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(BELOW_LINE);
        System.out.println(FOURTH_PRIZE_MESSAGE + hashMap.get(MIN_MATCH_NUMBER) + PIECE);
        System.out.println(THIRD_PRIZE_MESSAGE + hashMap.get(FOUR_MATCH_NUMBER) + PIECE);
        System.out.println(SECOND_PRIZE_MESSAGE + hashMap.get(FIVE_MATCH_NUMBER) + PIECE);
        System.out.println(FIRST_PRIZE_MESSAGE + hashMap.get(MAX_MATCH_NUMBER) + PIECE);
    }

    public static void printLottoRateOfReturn(String lottoRateOfReturn) {
        System.out.println(TOTAL_RETURN_MESSAGE + lottoRateOfReturn + IS);
    }

    public static void printMyLottoNumber(List<List<Integer>> lottoNumbers, int ticketOfLotto) {
        for (int i = 0; i < ticketOfLotto; i++) {
            System.out.println(lottoNumbers.get(i));
        }
    }
}
