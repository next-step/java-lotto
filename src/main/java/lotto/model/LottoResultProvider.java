package lotto.model;

import java.util.List;

public class LottoResultProvider {

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;


    public LottoResultProvider(List<Lotto> lottos, List<Integer> winningNubmers) {
        this.lottos = lottos;
        this.winningNumbers = winningNubmers;
    }

}
