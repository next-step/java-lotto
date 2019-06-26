package lotto.model;

import java.util.List;

public class LottoResult {

    private List<Lotto> lottos;
    private List<Integer> winningNubmers;


    public LottoResult(List<Lotto> lottos, List<Integer> winningNubmers) {
        this.lottos = lottos;
        this.winningNubmers = winningNubmers;
    }

    public int getThreeCorrectResult() {
        return 3;
    }
}
