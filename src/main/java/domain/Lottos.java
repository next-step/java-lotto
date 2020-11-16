package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<List<Integer>> lottoNumbers){
        Objects.requireNonNull(lottoNumbers);
        lottoNumbers.forEach( lottoNumber -> lottos.add(new Lotto(lottoNumber)) );
    }

    public LottoResult makeStatistics(List<Integer> winningNumbers) throws Exception {
        LottoResult lottoResult = new LottoResult();

        lottos.stream().forEach(lotto -> lottoResult.checkWhetherToWin(lotto.countMatching(winningNumbers)));
        lottoResult.calculateProfitRates(lottos.size());

        return lottoResult;
    }
}
