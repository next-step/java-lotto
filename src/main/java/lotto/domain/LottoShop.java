package lotto.domain;

import lotto.domain.result.LottoResults;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public static List<LottoNumbers> lottos = new ArrayList<>();

    public LottoShop() {}

    public void playLotto(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new LottoNumbers());
        }
    }

    public LottoResults getLottoResult(List<Integer> winningNumber) {
        LottoResults lottoResults = LottoResults.of();
        for (LottoNumbers lottoNumbers : lottos) {
            int hitCount = lottoNumbers.getHitCount(winningNumber);
            lottoResults.win(hitCount);
        }
        return lottoResults;
    }
}
