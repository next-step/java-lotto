package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;

import java.util.List;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService() {
        this.lottoGenerator = new LottoGenerator();
    }

    public List<Lotto> buyLottos(int money) {
        return lottoGenerator.generate(money);
    }

    public LottoResult calculateResult(List<Lotto> lottos, Lotto winningLotto) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            lottoResult.add(matchCount);
        }

        return lottoResult;
    }
}
