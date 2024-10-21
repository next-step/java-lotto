package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLottoNumbers extends LottoNumbers {
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        super(lottoNumbers);

        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumbersResults getResult(List<LottoNumbers> lottoNumbersList) {
        Map<LottoCashPrize, Integer> lottoNumbersResults = new HashMap<>();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            LottoCashPrize prize = LottoCashPrize.from(
                    lottoNumbers.getMatchedCount(this), lottoNumbers.isContained(bonusNumber));

            lottoNumbersResults.put(prize, lottoNumbersResults.getOrDefault(prize, 0) + 1);
        }

        return new LottoNumbersResults(lottoNumbersResults);
    }
}
