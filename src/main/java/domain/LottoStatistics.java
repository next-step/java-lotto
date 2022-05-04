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

    public double calculateNumbersCount(LottoRank lottoRank) {
        if (LottoRank.checkBonusRank(lottoRank)) {
            return calculateNumbersAndBonusNumberCount();
        }
        return lottos.calculateNumbers(lottoWinningNumbers, lottoRank.getLottoMatchCount());
    }

    private double calculateNumbersAndBonusNumberCount() {
        return lottos.calculateNumbersAndBonusNumber(lottoWinningNumbers.getWinningLotto()
                , lottoWinningNumbers.getBonusNumber());
    }

    public double statistics() {
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        double result = Arrays.stream(LottoRank.values())
                .mapToDouble(lottoRank -> calculateNumbersCount(lottoRank) * lottoRank.getLottoRankMoney())
                .sum();

        return Double.parseDouble(decimalFormat.format(result / (lottos.size() * LOTTO_PRICE)));
    }

}
