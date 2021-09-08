package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        lottos = new ArrayList<>(lottoList);
    }

    public List<String> toStringLottos() {
        return lottos.stream().map(Lotto::toStringLottoNumber).collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }

    public LottoResult result(Lotto winningLotto, int amount) {
        LottoResult lottoResult = new LottoResult(amount);
        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.checkWinning(winningLotto);
            lottoResult.record(rank);
        }
        return lottoResult;
    }
}
