package step4.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final Map<Prize, Integer> drawResult = new LinkedHashMap();

    public LottoResult(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static final LottoResult from(final List<Integer> winningNumbers) {
        return new LottoResult(winningNumbers);
    }

    public final Map<Prize, Integer> drawLottoResult(final List<LottoNumbers> allLottoNumbers,
        int bonusBall) {
        for (LottoNumbers eachLottoNumber : allLottoNumbers) {
            int matchCount = eachLottoNumber.calculateMatchCount(winningNumbers);
            boolean isBonusBallMatch = eachLottoNumber.hasNumber(bonusBall);
            Prize prize = Prize.valueOf(matchCount, isBonusBallMatch);
            drawResult.put(prize, drawResult.getOrDefault(prize, 0) + 1);
        }

        return drawResult;
    }
}
