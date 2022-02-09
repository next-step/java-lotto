package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int ZERO = 0;

    private final Map<Ranking, Integer> totalResult = new HashMap<>();

    public LottoGame() {
        initializeTotalResult();
    }

    private void initializeTotalResult() {
        Arrays.stream(Ranking.values())
            .forEach(ranking -> totalResult.put(ranking, ZERO));
    }

    public Lottos startLotto(final int price, final LottoShop lottoShop) {
        final int lottoAmount = lottoShop.countPossibleLottoAmount(price);
        return lottoShop.buyLotto(lottoAmount);
    }

    public Map<Ranking, Integer> findWinner(final List<LottoNumber> winningNumbers,
        final Lottos userLottos,
        final LottoNumber bonusNumber) {

        final LottoCalculator lottoCalculator = LottoCalculator.getInstance();

        for (Lotto lotto : userLottos.getLottos()) {
            Ranking ranking = lottoCalculator.calculate(winningNumbers,
                lotto.getLottoNumbers(),
                bonusNumber);

            updateResult(ranking);
        }
        return totalResult;
    }

    private void updateResult(final Ranking ranking) {
        Integer currentCount = totalResult.get(ranking);
        totalResult.put(ranking, ++currentCount);
    }

}
