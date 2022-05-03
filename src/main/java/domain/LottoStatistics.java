package domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class LottoStatistics {
    private static final int LOTTO_PRICE = 1000;
    private final Lottos lottos;
    private final LottoWinningNumbers lottoWinningNumbers;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public LottoStatistics(BuyLotto buyLotto, LottoWinningNumbers lottoWinningNumbers) {
        this.lottos = buyLotto.getLottos();
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public double calculateNumbersCount(int winningMoney) {
        if(winningMoney == LottoRank.valueOf("FIVE_NUMBERS_AND_BONUS").getLottoRankMoney()) {
            return calculateNumbersAndBonusNumberCount();
        }
        return lottos.calculateNumbers(lottoWinningNumbers
            , LottoRank.valueOf(winningMoney)
                .getLottoRank());
    }

    private double calculateNumbersAndBonusNumberCount() {
        return lottos.calculateNumbersAndBonusNumber(lottoWinningNumbers.getWinningLotto()
                , lottoWinningNumbers.getBonusNumber());
    }

    public double statistics() {
        double result;
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        result = Arrays.stream(LottoRank.values())
            .mapToDouble(lottoRank -> calculateNumbersCount(lottoRank.getLottoRankMoney()) * lottoRank.getLottoRankMoney())
            .sum();

        return Double.parseDouble(decimalFormat.format(result / (lottos.size() * LOTTO_PRICE)));
    }

}
