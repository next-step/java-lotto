package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int ZERO = 0;

    private final StringBuilder stringBuilder = new StringBuilder();
    private final Map<Ranking, Integer> totalResult = new HashMap<>();

    public LottoGame() {
        initializeTotalResult();
    }

    private void initializeTotalResult() {
        totalResult.put(Ranking.FIRST, ZERO);
        totalResult.put(Ranking.SECOND, ZERO);
        totalResult.put(Ranking.THIRD, ZERO);
        totalResult.put(Ranking.FOURTH, ZERO);
        totalResult.put(Ranking.FIFTH, ZERO);
    }

    public Lottos startLotto(final int price, final LottoShop lottoShop) {
        final int lottoAmount = lottoShop.countPossibleLottoAmount(price);

        stringBuilder.append(lottoAmount)
            .append("개를 구매했습니다.");
        System.out.println(stringBuilder);

        return lottoShop.buyLotto(lottoAmount);
    }

    public Map<Ranking, Integer> findWinner(final List<LottoNumber> winningNumbers, final Lottos userLottos,
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
        if (totalResult.containsKey(ranking)) {
            Integer currentCount = totalResult.get(ranking);
            totalResult.put(ranking, ++currentCount);
        }
    }

}
