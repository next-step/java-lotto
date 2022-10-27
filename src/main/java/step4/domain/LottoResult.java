package step4.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final Set<LottoNumber> winningNumbers;
    private final Map<Prize, Integer> drawResult = new LinkedHashMap();

    public LottoResult(final Set<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static final LottoResult from(final Set<LottoNumber> winningNumbers) {
        return new LottoResult(winningNumbers);
    }

    public final Map<Prize, Integer> drawLottoResult(final List<LottoNumbers> allLottoNumbers,
        LottoNumber bonusBall) {
        drawResult.clear();
        for (LottoNumbers eachLottoNumber : allLottoNumbers) {
            int matchCount = eachLottoNumber.calculateMatchCount(winningNumbers);
            boolean isBonusBallMatch = eachLottoNumber.hasNumber(bonusBall);
            Prize prize = Prize.valueOf(matchCount, isBonusBallMatch);
            drawResult.put(prize, drawResult.getOrDefault(prize, 0) + 1);
        }

        return drawResult;
    }
}
