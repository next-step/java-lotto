package step2.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final Map<Integer, Integer> drawResult = new LinkedHashMap();
    private final int LEAST_DRAW_COUNT = 3;

    private LottoResult(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public static LottoResult from(List<Integer> winningNumbers) {
        return new LottoResult(winningNumbers);
    }

    public Map<Integer, Integer> drawLottoResult(List<LottoNumber> allLottoNumbers) {
        for (LottoNumber eachLottoNumber : allLottoNumbers) {
            List<Integer> lottoNumbers = eachLottoNumber.getLottoNumbers();
            drawEachLottoResult(eachLottoNumber, lottoNumbers);
        }

        return drawResult;
    }

    private void drawEachLottoResult(LottoNumber eachLottoNumber, List<Integer> lottoNumbers) {
        int count = (int) winningNumbers.stream()
            .filter(winningNumber -> lottoNumbers.contains(winningNumber))
            .count();

        if (count >= LEAST_DRAW_COUNT) {
            drawResult.put(count, drawResult.getOrDefault(count, 0) + 1);
        }
    }
}
