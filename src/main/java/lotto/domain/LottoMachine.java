package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int FIRST_PRIZE_MATCH_COUNT = 6;
    public static final int SECOND_PRIZE_MATCH_COUNT = 5;
    public static final int THIRD_PRIZE_MATCH_COUNT = 5;
    public static final int FOURTH_PRIZE_MATCH_COUNT = 4;
    public static final int FIFTH_PRIZE_MATCH_COUNT = 3;

    private final List<Integer> prizeMoneys;
    private LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.simple();

    public LottoMachine(List<Integer> prizeMoneys) {
        this.prizeMoneys = prizeMoneys;
    }

    public List<Lotto> issue(int purchaseAmount) {
        int howManyLottosCanIBuy = purchaseAmount / Lotto.PRICE;

        return IntStream.range(0, howManyLottosCanIBuy)
                .mapToObj(it -> generateLotto())
                .collect(Collectors.toList());
    }

    public PrizeWinningResult checkPrizeWinning(Lottos lottos, WinningNumber winningNumber) {
        return PrizeWinningResult
                .builder()
                .paidMoney(lottos.getPaidMoney())
                .prizeMoneys(this.prizeMoneys.get(0), this.prizeMoneys.get(1), this.prizeMoneys.get(2), this.prizeMoneys.get(3), this.prizeMoneys.get(4))
                .firstPrize(lottos.finder(winningNumber).findMatched(FIRST_PRIZE_MATCH_COUNT).lottos())
                .secondPrize(lottos.finder(winningNumber).findMatched(SECOND_PRIZE_MATCH_COUNT).findMatchBonus().lottos())
                .thirdPrize(lottos.finder(winningNumber).findMatched(THIRD_PRIZE_MATCH_COUNT).excludeMatchBonus().lottos())
                .fourthPrize(lottos.finder(winningNumber).findMatched(FOURTH_PRIZE_MATCH_COUNT).lottos())
                .fifthPrize(lottos.finder(winningNumber).findMatched(FIFTH_PRIZE_MATCH_COUNT).lottos())
                .build();
    }

    private Lotto generateLotto() {
        return new Lotto(lottoNumberGenerator.generate());
    }


}
