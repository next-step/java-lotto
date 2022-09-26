package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
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
        return new LottoStatistics(getMatchCounts(winningNumber));
    }

    private List<Integer> getMatchCounts(String winningNumber) {
        Lotto winLotto = createLotto(winningNumber);

        return lottos.values()
                .stream()
                .map(lotto -> lotto.matchCount(winLotto))
                .collect(Collectors.toList());
    }

    private static Lotto createLotto(String lottoNumbers) {
        return Lotto.create(lottoNumbers);
    }
}
