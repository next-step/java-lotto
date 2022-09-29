package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.type.Match;
import lotto.view.LottoResult;
import lotto.view.LottoStatistics;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private Lottos lottos;

    public LottoResult buyLotto(int money) {
        return LottoResult.of(buy(money));
    }

    public Lottos buy(int money) {
        int quantity = getQuantity(money);
        lottos = Lottos.create(quantity);
        return lottos;
    }

    private int getQuantity(int money) {
        return money / Lotto.PRICE;
    }

    public LottoStatistics lottoStatistics(String winningNumber) {
        Lotto winLotto = createLotto(winningNumber);

        List<Match> types = lottos.values()
                .stream()
                .map(lotto -> lotto.rank(winLotto))
                .collect(Collectors.toList());

        return new LottoStatistics(types);
    }

    private static Lotto createLotto(String lottoNumbers) {
        return Lotto.create(lottoNumbers);
    }
}
