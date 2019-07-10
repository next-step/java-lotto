package domain;

import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private LottoRevenue lottoRevenue;

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교하여 당첨 번호 갯수 확인
    public void getWinningResult(List<LottoNumber> lottoNumber, String inputWinningNumber, int bonusBall, int purchaseAmount) {
        int[] winningNumber = LottoUtil.coverStrToArr(inputWinningNumber);
        Integer[] countsOfWinningResult = new Integer[lottoNumber.size()];

        for (int i = 0; i < lottoNumber.size(); i++) {
            countsOfWinningResult[i] = lottoNumber.get(i).compareWinningNumber(winningNumber, bonusBall);
        }

        LottoRankData.setCountsOfWinningResultConvertList(Arrays.asList(countsOfWinningResult));
        lottoRevenue = new LottoRevenue(calculatorRevenue(LottoRankData.calculatorTotalWinningRevenue(), purchaseAmount));
    }

    public LottoRevenue getWinningRevenue() {
        return lottoRevenue;
    }

    private double calculatorRevenue(double total, int lottoPrice) {
        return total / lottoPrice;
    }
}
