package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        lottos = new ArrayList<>(lottoList);
    }

    public List<Lotto> values() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public LottoResult result(LottoNumbers winningNumbers, int amount) {
        LottoResult lottoResult = new LottoResult(amount);
        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.checkWinning(winningNumbers);
            lottoResult.record(rank);
        }
        return lottoResult;
    }
}
