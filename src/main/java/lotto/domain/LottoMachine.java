package lotto.domain;

import lotto.domain.purchaseStrategy.PurchaseStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LottoMachine {

    private static final String BELOW_MIN_AMOUNT_ERROR_MESSAGE = "최소 1000원 이상 지불하셔야 합니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int INIT_COUNT = 0;
    private static final boolean ADD_COMMAND = true;

    public Lottos buyLotto(final int amount, final PurchaseStrategy purchaseStrategy) {
        validateAmount(amount);
        return new Lottos(printLotto(amount, purchaseStrategy));
    }

    private void validateAmount(final int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(BELOW_MIN_AMOUNT_ERROR_MESSAGE);
        }
    }

    private List<Lotto> printLotto(final int amount, final PurchaseStrategy purchaseStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = INIT_COUNT; i < amount / LOTTO_PRICE; i++) {
            lottos.add(new Lotto(purchaseStrategy.generateLottoNumber()));
        }

        return lottos;
    }

    public Map<Rank, MatchingCount> makeStatisticsWinnings(final Lottos lottos, final Lotto winningLotto) {
        Map<Rank, MatchingCount> winnings = new HashMap<>();

        for (Lotto lotto : lottos.getLottos()) {
            MatchingCount matchingCount = matchingNumbers(lotto, winningLotto);
            Rank rank = Rank.returnRank(matchingCount);

            winnings.put(rank, new MatchingCount(winnings.getOrDefault(rank, new MatchingCount()).getMatchingCount()).addMatchingCount(ADD_COMMAND));
        }

        return winnings;
    }

    private MatchingCount matchingNumbers(final Lotto lotto, final Lotto winningLotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        MatchingCount matchingCount = new MatchingCount();

        for (LottoNumber lottoNumber : lottoNumbers) {
            matchingCount = matchingCount.addMatchingCount(winningLotto.matchingNumber(lottoNumber));
        }

        return matchingCount;
    }

    public double calculateEarningsRate(final Map<Rank, MatchingCount> winnings, final int totalCount) {
        int totalPrize = 0;

        for (Rank rank : winnings.keySet()) {
            totalPrize += rank.getWinningMoney() * winnings.get(rank).getMatchingCount();
        }

        return Math.round((float) totalPrize / (totalCount * 10)) / 100.0;
    }

}
