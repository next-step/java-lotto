package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final static int SUBSTR_POINT_ONE = 1;
    private final static int SUBSTR_POINT_TWO = 2;

    private static double winningRevenue;
    private static Integer[] countsOfWinningResult;

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교하여 당첨 번호 갯수 확인
    public static void getCountsWinningResult(ArrayList<LottoNumber> lottoNumber, int[] winnigNumber, int bonusBall, int purchaseAmount) {
        countsOfWinningResult = new Integer[lottoNumber.size()];
        for (int i = 0; i < lottoNumber.size(); i++) {
            countsOfWinningResult[i] = lottoNumber.get(i).compareWinningNumber(winnigNumber, bonusBall);
        }
        calculatorTotalWinningRevenue(purchaseAmount);
    }

    private static void calculatorTotalWinningRevenue(int lottoPrice) {
        LottoData.setCountsOfWinningResultConvertList(Arrays.asList(countsOfWinningResult)); //당첨 번호 갯수에 따라서 몇등인지 확인하기 위하여  Array -> List 로 변환

        double totalWinningPrize = (LottoData.FIRST_WINNER.getCountWinner() * LottoData.FIRST_WINNER.getPrize()) + (LottoData.SECOND_WINNER.getCountWinner() * LottoData.SECOND_WINNER.getPrize())
                + (LottoData.THIRD_WINNER.getCountWinner() * LottoData.THIRD_WINNER.getPrize()) + (LottoData.FORTH_WINNER.getCountWinner() * LottoData.FORTH_WINNER.getPrize())
                + (LottoData.BOBUS_SECOND_WINNER.getCountWinner() * LottoData.BOBUS_SECOND_WINNER.getPrize());

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
        countOfWinner.put(LottoData.FIRST_WINNER.getPrize(), (int) LottoData.FIRST_WINNER.getCountWinner());
        countOfWinner.put(LottoData.SECOND_WINNER.getPrize(), (int) LottoData.SECOND_WINNER.getCountWinner());
        countOfWinner.put(LottoData.THIRD_WINNER.getPrize(), (int) LottoData.THIRD_WINNER.getCountWinner());
        countOfWinner.put(LottoData.FORTH_WINNER.getPrize(), (int) LottoData.FORTH_WINNER.getCountWinner());
        countOfWinner.put(LottoData.BOBUS_SECOND_WINNER.getPrize(), (int) LottoData.BOBUS_SECOND_WINNER.getCountWinner());
        return countOfWinner;
    }

    // 수익율이 이익인지 손해인지 판단 (출력용)
    public static String judgeResult() {
        if (winningRevenue > 1)
            return "이익";
        if (winningRevenue == 1)
            return "본전";
        return "손해";
    }
}
