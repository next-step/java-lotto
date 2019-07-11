package lottogame.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public class LottoResult {
    private LottoRevenue lottoRevenue;

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교하여 당첨 번호 갯수 확인
    public void getWinningResult(LottoGame lottoGame, WinningLottoNumber winningLottoNumber) {
        Integer[] countsOfWinningResult = lottoGame.getLotto().stream()
                .map(lottoNumber -> lottoNumber.compareWinningNumber(winningLottoNumber.getWinningNumber(), winningLottoNumber.bonusBall)).toArray(Integer[]::new);

        LottoRankData.setCountsOfWinningResultConvertList(Arrays.asList(countsOfWinningResult));
        lottoRevenue = new LottoRevenue(calculatorRevenue(LottoRankData.calculatorTotalWinningRevenue(), lottoGame.getPrice().getPrice()));
    }

    public LottoRevenue getWinningRevenue() {
        return lottoRevenue;
    }

    private BigDecimal calculatorRevenue(double total, int lottoPrice) {
        return new BigDecimal(total / lottoPrice);
    }
}
