package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottosResult {
    private final List<LottoResult> lottosResult;

    private LottosResult(List<LottoResult> lottoResultList) {
        this.lottosResult = lottoResultList;
    }

    public static LottosResult of(Lottos lottos) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto lotto : lottos.getLottos()) {
            lottoResults.add(LottoResult.of(lotto));
        }

        return new LottosResult(lottoResults);
    }

    public List<LottoResult> getLottosResult() {
        return this.lottosResult;
    }

    public int size() {
        return lottosResult.size();
    }
}
