package domain;

import java.util.List;

public class LottoCalculator {
    private Lottos lottos;

    public LottoCalculator(List<List<Integer>> lottoNumbers) {
        lottos = new Lottos(lottoNumbers);
    }

    public Lottos getLottos(){
        return lottos;
    }

    public LottoResult calculate() {
      return new LottoResult();//  lottos.countMatchingNumber();
    };

}
