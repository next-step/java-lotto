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

    public LottoResult result(WinningNumber winningNumber, int amount) {
        LottoResult lottoResult = new LottoResult(amount);
        for (Lotto lotto : lottos) {
            LottoRank rank = winningNumber.checkWinning(lotto);
            lottoResult.record(rank);
        }
        return lottoResult;
    }
}
