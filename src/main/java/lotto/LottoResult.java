package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;

import java.util.List;

public class LottoResult {
    private final LottoRankCounter lottoRankCounter;

    public LottoResult(LottoNumbers winnerLottoNumbers, LottoNumber bonusLottoNumber, List<LottoNumbers> lottoNumbersBundle) {
        this.lottoRankCounter = createLottoRankCounter(winnerLottoNumbers, bonusLottoNumber, lottoNumbersBundle);
    }

    public float computeIncomeRate() {
        float totalRankMoney = lottoRankCounter.getTotalLottoMoney();

        float purchaseAmounts = LottoFactory.SINGLE_LOTTO_MONEY * lottoRankCounter.size();
        float rawIncomeRate = totalRankMoney / purchaseAmounts;
        return changeDecimalTwoPoint(rawIncomeRate);
    }

    public int countOfLottoRankMatched(LottoRank lottoRank) {
        return this.lottoRankCounter.getCount(lottoRank);
    }

    private float changeDecimalTwoPoint(float value) {
        String stringValue = String.format("%.02f", value);
        return Float.parseFloat(stringValue);
    }

    private LottoRankCounter createLottoRankCounter(LottoNumbers winnerLottoNumbers, LottoNumber bonusLottoNumber, List<LottoNumbers> lottoNumbersBundle) {
        LottoRankCounter lottoRankCounter = new LottoRankCounter();
        lottoNumbersBundle.stream()
                          .map(lottoNumbers -> lottoNumbers.toLottoRank(winnerLottoNumbers, bonusLottoNumber))
                          .forEach(lottoRankCounter::addCount);

        return lottoRankCounter;
    }
}
