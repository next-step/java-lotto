package lotto;

import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinCalculator {
    public static final int LOTTO_PRICE = 1000;

    private final Lotto winLottoNumbers;
    private final LottoNumber bonusNumber;
    private final LottoWinResult lottoWinResult;

    public LottoWinCalculator(Lotto winLottoNumbers, LottoNumber bonusNumber) {
        this.winLottoNumbers = winLottoNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoWinResult = new LottoWinResult();
    }

    /**
     * 당첨상금 별 갯수를 리턴합니다.
     * @return
     */
    public LottoWinResult findLottoWinPrize(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            this.lottoWinResult.addWinResultCount(this.calculateMatchedCounts(lotto)
                                                , this.containBonusNumber(lotto));
        }
        return this.lottoWinResult;
    }

    /**
     * 세팅 된 당첨번호와 발급 된 로또번호를 비교하여 각 일치하는 개수 목록을 반환합니다.
     * @return
     */
    private int calculateMatchedCounts(Lotto lotto) {
        return lotto.getLottoNumbers()
                .matchedLottoNumbersCount(this.winLottoNumbers.getLottoNumbers());
    }

    /**
     * 세팅 된 당첨번호와 발급 된 로또번호를 비교하여 각 일치하는 개수 목록을 반환합니다.
     * @return
     */
    List<Integer> calculateMatchedCounts(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(lotto -> lotto.getLottoNumbers()
                        .matchedLottoNumbersCount(this.winLottoNumbers.getLottoNumbers()))
                .collect(Collectors.toList());
    }

    private boolean containBonusNumber(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }
}
