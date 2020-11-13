package domain;

import java.util.List;

public class LottoCalculator {
    private Lottos lottos;

    public LottoCalculator(List<List<Integer>> lottoNumbers) {
        lottos = new Lottos(lottoNumbers);
    }

    public LottoResult calculate(List<Integer> winningNumbers) throws Exception {
        return lottos.makeStatistics(winningNumbers);
    }

}
