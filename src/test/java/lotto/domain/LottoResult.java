package lotto.domain;

import common.StringResources;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResultNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<LottoNumber> lottoNumberList;
    private final LottoResultNumber lottoResultNumber;

    private final Map<Integer, Integer> winCount;

    public LottoResult(List<LottoNumber> lottoNumberList, LottoResultNumber lottoResultNumber) {
        this.lottoNumberList = lottoNumberList;
        this.lottoResultNumber = lottoResultNumber;
        this.winCount = new HashMap<>();

        winCount.put(3, 0);
        winCount.put(4, 0);
        winCount.put(5, 0);
        winCount.put(6, 0);

        matchItemsCheck();
    }

    private void matchItemsCheck() {

        for (LottoNumber lottoNumber : lottoNumberList) {
            long count = lottoNumber.getNumbers().stream()
                    .flatMap(i -> lottoResultNumber.getNumbers().stream()
                            .map(j -> new int[] { i, j } ))
                    .filter(array -> array[0] == array[1])
                    .count();

            winCount.computeIfPresent((int) count, (Integer key, Integer value) -> ++value);
        }
    }

    public int getWinningCount(int matchCount) {

        if (matchCount < 0 || matchCount > 6) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RANGE_RESULT_NUMBER);
        }

        return winCount.get(matchCount);
    }
}
