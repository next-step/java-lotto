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

    public LottoResult calculate(List<Integer> winningNumbers) throws Exception {
        LottoResult lottoResult = new LottoResult();

        lottos.stream().forEach(lotto -> lottoResult.addPrizeResult(lotto.checkWhetherToWin(winningNumbers)));
        lottoResult.calculateProfitRates(lottos.size());

        return lottoResult;
    }

    public Stream stream(){
        return lottos.stream();
    }

    public int size() {
        return lottos.size();
    }
}
