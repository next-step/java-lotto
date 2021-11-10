package lotto.vo;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public static Lottos create(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public int count() {
        return lottos.size();
    }

    public List<WinningRank> checkWinning(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.checkWinning(winningLotto))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
