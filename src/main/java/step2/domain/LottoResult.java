package step2.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final Map<Prize, Integer> drawResult = new LinkedHashMap();
    private final int LEAST_DRAW_COUNT = 3;

    public LottoResult(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public static final LottoResult from(final List<Integer> winningNumbers) {
        return new LottoResult(winningNumbers);
    }

    public final Map<Prize, Integer> drawLottoResult(final List<LottoNumbers> allLottoNumbers) {
        for (LottoNumbers eachLottoNumber : allLottoNumbers) {
            List<Integer> lottoNumbers = eachLottoNumber.getLottoNumbers();
            int matchCount = calculateMatchCount(lottoNumbers);

            if (matchCount >= LEAST_DRAW_COUNT) {
                Prize prize = Prize.getPrize(matchCount);
                drawResult.put(prize, drawResult.getOrDefault(prize, 0) + 1);
            }
        }

        return drawResult;
    }

    private int calculateMatchCount(List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
