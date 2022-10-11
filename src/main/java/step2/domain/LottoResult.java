package step2.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final Map<LottoNumber, Integer> drawResult = new LinkedHashMap();

    private LottoResult(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    public static LottoResult from(List<Integer> winningNumbers) {
        return new LottoResult(winningNumbers);
    }

    public Map<LottoNumber, Integer> drawLottoResult(List<LottoNumber> allLottoNumbers) {
        for (LottoNumber eachLottoNumber : allLottoNumbers) {
            List<Integer> lottoNumbers = eachLottoNumber.getLottoNumbers();
            drawEachLottoResult(eachLottoNumber, lottoNumbers);
        }

        return drawResult;
    }

    private void drawEachLottoResult(LottoNumber eachLottoNumber, List<Integer> lottoNumbers) {
        for (int winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                drawResult.put(eachLottoNumber, drawResult.getOrDefault(eachLottoNumber, 0) + 1);
            }
        }
    }
}
