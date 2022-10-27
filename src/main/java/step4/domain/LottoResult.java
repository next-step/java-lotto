package step4.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final Set<LottoNumber> winningNumbers;
    private final Map<Prize, Integer> lottoResult = new LinkedHashMap<>();
    private final LottoNumber bonusNumber;

    private LottoResult(final Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static final LottoResult of(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        return new LottoResult(winningNumbers, bonusNumber);
    }

    public final void drawLottoResult(final List<LottoNumbers> allLottoNumbers) {
        lottoResult.clear();
        for (LottoNumbers eachLottoNumber : allLottoNumbers) {
            int matchCount = eachLottoNumber.calculateMatchCount(winningNumbers);
            boolean isBonusBallMatch = eachLottoNumber.hasNumber(bonusNumber);
            Prize prize = Prize.valueOf(matchCount, isBonusBallMatch);
            lottoResult.put(prize, lottoResult.getOrDefault(prize, 0) + 1);
        }
    }

    public Map<Prize, Integer> getLottoResult() {
        return lottoResult;
    }
}
