package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService() {
        this.lottoGenerator = new LottoGenerator();
    }

    public List<Lotto> buyLottos(int money) {
        return lottoGenerator.generate(money);
    }

    public LottoResult calculateResult(List<Lotto> lottos, Lotto winningLotto) {
        List<LottoResult.Rank> ranks =
                lottos.stream().map(lotto -> lotto.countMatchingNumbers(winningLotto))
                        .map(LottoResult.Rank::valueOf).collect(Collectors.toList());
        return new LottoResult(ranks);
    }
}
