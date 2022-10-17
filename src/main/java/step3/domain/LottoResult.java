package step3.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final Map<Prize, Integer> drawResult = new LinkedHashMap();

    public LottoResult(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public static final LottoResult from(final List<Integer> winningNumbers) {
        return new LottoResult(winningNumbers);
    }

    public final Map<Prize, Integer> drawLottoResult(final List<LottoNumbers> allLottoNumbers, boolean matchBonus) {
        for (LottoNumbers eachLottoNumber : allLottoNumbers) {
            Set<Integer> lottoNumbers = eachLottoNumber.getLottoNumbers();
            int matchCount = calculateMatchCount(lottoNumbers);

            Prize prize = Prize.valueOf(matchCount, false);
            drawResult.put(prize, drawResult.getOrDefault(prize, 0) + 1);
        }

        drawResult.remove(Prize.MISS);
        return drawResult;
    }

    private int calculateMatchCount(Set<Integer> lottoNumbers) {
        int matchCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
