package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottosBundle {

    private static final Money price = Money.from(1_000);

    private final List<Lottos> multipleLottos;

    private LottosBundle(List<Lottos> multipleLottos) {
        this.multipleLottos = multipleLottos;
    }

    public static LottosBundle from(List<Lottos> multipleLottos) {
        return new LottosBundle(multipleLottos);
    }

    public static LottosBundle fromNumbers(List<Numbers> numbers) {
        List<Lottos> mulitpleLottos = numbers.stream()
                                                .map(Lottos::from)
                                                .collect(Collectors.toUnmodifiableList());
        return new LottosBundle(mulitpleLottos);
    }

    public static LottosBundle autoFrom(Number count) {
        List<Lottos> multipleLottos = new ArrayList<>();

        while (count.isPositive()) {
            multipleLottos.add(Lottos.from());
            count = count.decrease();
        }

        return from(multipleLottos);
    }

    public static LottosBundle manualFrom(List<Numbers> numbers) {
        return fromNumbers(numbers);
    }

    public static Number calculateCountOfLottos(Money money) {
        return Number.from(money.divideToInt(price));
    }

    public LottosBundle merge(LottosBundle multipleLottos) {
        List<Lottos> merged = new ArrayList<>(this.multipleLottos);
        merged.addAll(multipleLottos.multipleLottos);
        return new LottosBundle(merged);
    }

    public List<Lottos> getMultipleLottos() {
        return multipleLottos;
    }

    public int size() {
        return multipleLottos.size();
    }

    public List<Rank> checkRanks(WinningLottos winningLottos) {
        return multipleLottos.stream()
                .map(winningLottos::checkRank)
                .collect(Collectors.toUnmodifiableList());
    }

    public Rate calculateReturnOfRate(WinningLottos winnerLotto) {
        Money purchaseAmount = calculatePurchaseAmount(price);
        Money sumOfPrize = calculateSumOfPrize(winnerLotto);
        return Rate.fromDouble(sumOfPrize.divideToDouble(purchaseAmount));
    }

    private Money calculatePurchaseAmount(Money lottoPrice) {
        return lottoPrice.multiply(Number.from(size()));
    }

    private Money calculateSumOfPrize(WinningLottos winnerLotto) {
        Number purchaseAmount = multipleLottos.stream()
                .map(winnerLotto::calculatePrize)
                .reduce(Number.from(0), Number::add);
        return Money.fromNumber(purchaseAmount);
    }
}
