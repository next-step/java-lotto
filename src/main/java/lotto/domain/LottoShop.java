package lotto.domain;

import lotto.domain.result.LottoResults;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public static List<LottoNumber> lottos = new ArrayList<>();

    public LottoShop() {}

    public void playLotto(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new LottoNumber());
        }
    }
    public LottoResults getLottoResult(List<Integer> winningNumber) {
        LottoResults lottoResults = LottoResults.of();
        for (LottoNumber lottoNumber : lottos) {
            int hitCount = lottoNumber.getHitCount(winningNumber);
            lottoResults.win(hitCount);
        }
        return lottoResults;
    }
}
