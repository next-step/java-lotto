package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        Objects.requireNonNull(lottos);
        this.lottos = lottos;
    }

    public LottoResult calculate(Lotto winningLotto) {
        LottoResult lottoResult = new LottoResult();

        lottos.forEach(lotto -> lottoResult.addPrizeResult(lotto.checkWhetherToWin(winningLotto)));

        return lottoResult;
    }

    public Stream stream(){
        return lottos.stream();
    }

    public int size() {
        return lottos.size();
    }
}
