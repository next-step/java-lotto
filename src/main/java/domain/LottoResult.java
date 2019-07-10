package domain;

import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private final static int SUBSTR_POINT_ONE = 1;
    private final static int SUBSTR_POINT_TWO = 2;

    private double winningRevenue;
    private Integer[] countsOfWinningResult;

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교하여 당첨 번호 갯수 확인
    public void getWinningResult(List<LottoNumber> lottoNumber, String inputWinningNumber, int bonusBall, int purchaseAmount) {
        int[] winningNumber = LottoUtil.coverStrToArr(inputWinningNumber);
        countsOfWinningResult = new Integer[lottoNumber.size()];

        for (int i = 0; i < lottoNumber.size(); i++) {
            countsOfWinningResult[i] = lottoNumber.get(i).compareWinningNumber(winningNumber, bonusBall);
        }

        calculatorTotalWinningRevenue(purchaseAmount);
    }

    // 계산된 수익율을 퍼센티지로 표현 (소수 2자리까지/ 단, 소수 한자리 일경우 한자리만 표현되도록 )
    public Double getPercentOfRevenue() {
        String[] result = String.valueOf(winningRevenue).split("\\.");
        String percent = null;
        if (result[1].length() == SUBSTR_POINT_ONE)
            percent = result[0] + "." + result[1].substring(0, SUBSTR_POINT_ONE);
        if (result[1].length() > SUBSTR_POINT_ONE)
            percent = result[0] + "." + result[1].substring(0, SUBSTR_POINT_TWO);
        return Double.parseDouble(percent);
    }

    public String judgeResult() {
        if (winningRevenue > 1)
            return "이익";
        if (winningRevenue == 1)
            return "본전";
        return "손해";
    }

    private void calculatorTotalWinningRevenue(int lottoPrice) {
        LottoRankData.setCountsOfWinningResultConvertList(Arrays.asList(countsOfWinningResult)); //당첨 번호 갯수에 따라서 몇등인지 확인하기 위하여  Array -> List 로 변환
        winningRevenue = getRevenue(LottoRankData.calculatorTotalWinningRevenue(), lottoPrice);
    }

    private double getRevenue(double total, int lottoPrice) {
        return total / lottoPrice;
    }

}
