package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int FIRST_PRIZE_MATCH_COUNT = 6;
    public static final int SECOND_PRIZE_MATCH_COUNT = 5;
    public static final int THIRD_PRIZE_MATCH_COUNT = 4;
    public static final int FOURTH_PRIZE_MATCH_COUNT = 3;

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
                .prizeMoneys(this.prizeMoneys.get(0), this.prizeMoneys.get(1), this.prizeMoneys.get(2), this.prizeMoneys.get(3))
                .firstPrize(lottos.findMatched(winningNumber, FIRST_PRIZE_MATCH_COUNT))
                .secondPrize(lottos.findMatched(winningNumber, SECOND_PRIZE_MATCH_COUNT))
                .thirdPrize(lottos.findMatched(winningNumber, THIRD_PRIZE_MATCH_COUNT))
                .fourthPrize(lottos.findMatched(winningNumber, FOURTH_PRIZE_MATCH_COUNT))
                .build();
    }

    private Lotto generateLotto() {
        return new Lotto(lottoNumberGenerator.generate());
    }


}
