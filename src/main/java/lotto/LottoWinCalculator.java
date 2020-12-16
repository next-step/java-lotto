package lotto;

import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinCalculator {
    public static final int LOTTO_PRICE = 1000;

    private final Lotto winLottoNumbers;
    private final LottoWinResult lottoWinResult;

    public LottoWinCalculator(Lotto winLottoNumbers) {
        this.winLottoNumbers = winLottoNumbers;
        this.lottoWinResult = new LottoWinResult();
    }

    /**
     * 당첨상금 별 갯수를 리턴합니다.
     * @return
     */
    public LottoWinResult findLottoWinPrize(Lottos lottos) {
        for (int matchedCount : this.calculateMatchedCounts(lottos)) {
            this.lottoWinResult.addWinResultCount(matchedCount);
        }
        return this.lottoWinResult;
    }

    /**
     * 세팅 된 당첨번호와 발급 된 로또번호를 비교하여 각 일치하는 개수를 반환합니다.
     * @return
     */
    List<Integer> calculateMatchedCounts(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(lotto -> lotto.getLottoNumbers()
                        .matchedLottoNumbersCount(this.winLottoNumbers.getLottoNumbers()))
                .collect(Collectors.toList());
    }
}
