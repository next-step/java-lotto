package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinnigCalculator {
    private final static int FIRST_WINNING_PRIZE = 2000000000;
    private final static int SECOND_WINNING_PRIZE = 1500000;
    private final static int THIRD_WINNING_PRIZE = 50000;
    private final static int FORTH_WINNING_PRIZE = 5000;

    public final static int FIRST_WINNING_POINT = 6;
    public final static int SECOND_WINNING_POINT = 5;
    public final static int THIRD_WINNING_POINT = 4;
    public final static int FORTH_WINNING_POINT = 3;

    private final static int SUBSTR_POINT_ONE = 1;
    private final static int SUBSTR_POINT_TWO = 2;

    private static double winningRevenue;

    private static List<Integer> countsOfWinningResultConvertList;

    // 당첨번호 갯수에 따라서 당첨금 계산
    public static void calculatorTotalWinningRevenue(Integer[] countsOfWinningResult, int lottoPrice) {
        countsOfWinningResultConvertList = Arrays.asList(countsOfWinningResult); //당첨 번호 갯수에 따라서 몇등인지 확인하기 위하여  Array -> List 로 변환

        double totalWinningPrize = (getCountFirstWinner() * FIRST_WINNING_PRIZE) + (getCountSecondWinner() * SECOND_WINNING_PRIZE)
                + (getCountThirdWinner() * THIRD_WINNING_PRIZE) + (getCountForthWinner() * FORTH_WINNING_PRIZE);

        winningRevenue = getRevenue(totalWinningPrize, lottoPrice);
    }

    private static double getRevenue(double total, int lottoPrice) {
        return total / lottoPrice;
    }

    // 계산된 수익율을 퍼센티지로 표현 (소수 2자리까지/ 단, 소수 한자리 일경우 한자리만 표현되도록 )
    public static Double getPercentOfRevenue() {
        String[] result = String.valueOf(winningRevenue).split("\\.");
        String percent = null;
        if (result[1].length() == SUBSTR_POINT_ONE)
            percent = result[0] + "." + result[1].substring(0, SUBSTR_POINT_ONE);
        if (result[1].length() > SUBSTR_POINT_ONE)
            percent = result[0] + "." + result[1].substring(0, SUBSTR_POINT_TWO);
        return Double.parseDouble(percent);
    }

    // hashmap 활용하여 등수별 count 수를 저장 (출력용)
    public static Map<Integer, Integer> getWinnerGroup() {
        Map<Integer, Integer> countOfWinner = new HashMap<>();
        countOfWinner.put(FIRST_WINNING_PRIZE, (int) getCountFirstWinner());
        countOfWinner.put(SECOND_WINNING_PRIZE, (int) getCountSecondWinner());
        countOfWinner.put(THIRD_WINNING_PRIZE, (int) getCountThirdWinner());
        countOfWinner.put(FORTH_WINNING_PRIZE, (int) getCountForthWinner());
        return countOfWinner;
    }

    // 1등 count 확인 (stream 활용)
    private static long getCountFirstWinner() {
        return countsOfWinningResultConvertList.stream().filter(x -> x.equals(FIRST_WINNING_POINT)).count();
    }

    // 2등 count 확인
    private static long getCountSecondWinner() {
        return countsOfWinningResultConvertList.stream().filter(x -> x.equals(SECOND_WINNING_POINT)).count();
    }

    // 3등 count 확인
    private static long getCountThirdWinner() {
        return countsOfWinningResultConvertList.stream().filter(x -> x.equals(THIRD_WINNING_POINT)).count();
    }

    // 4등 count 확인
    private static long getCountForthWinner() {
        return countsOfWinningResultConvertList.stream().filter(x -> x.equals(FORTH_WINNING_POINT)).count();
    }

    // 수익율이 이익인지 손해인지 판단 (출력용)
    public static String judgeResult() {
        if (winningRevenue > 1)
            return "이익";
        if (winningRevenue == 1)
            return "본전치기";
        return "손해";
    }
}
