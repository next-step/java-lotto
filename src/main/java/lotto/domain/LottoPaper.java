package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPaper {
    private final List<Lotto> values;

    private LottoPaper(final List<Lotto> values) {
        this.values = new ArrayList<>(values);
    }

    public static LottoPaper issue(final Money amount, final List<LottoNumbers> numbers) {
        final List<Lotto> lotteries = issueManual(numbers);
        lotteries.addAll(issueAutomatic(getBalance(amount, lotteries)));
        return new LottoPaper(lotteries);
    }

    public WinningStatistics viewResults(final WinningNumber winningNumber) {
        return new WinningStatistics(
                this.values
                        .stream()
                        .map(value -> value.winResult(winningNumber))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );
    }

    public List<Lotto> get() {
        return new ArrayList<>(this.values);
    }

    public int getLottoSize() {
        return this.values.size();
    }

    public long getAutomaticSize() {
        return this.values
                .stream()
                .filter(Lotto::isAutomatic)
                .count()
                ;
    }

    public long getManualSize() {
        return this.values
                .stream()
                .filter(Lotto::isManual)
                .count()
                ;
    }

    private static List<Lotto> issueManual(final List<LottoNumbers> numbers) {
        return numbers.stream()
                .map(Lotto::manual)
                .collect(Collectors.toList())
                ;
    }

    private static List<Lotto> issueAutomatic(final Money amount) {
        return IntStream.rangeClosed(1, getNumberOfLottoToPurchase(amount))
                .mapToObj(time -> Lotto.automatic())
                .collect(Collectors.toList())
                ;
    }

    private static int getNumberOfLottoToPurchase(final Money amount) {
        return amount.divide(Lotto.PRICE)
                .intValue()
                ;
    }

    private static Money getBalance(final Money amount, final List<Lotto> lotteries) {
        return amount.subtract(Lotto.PRICE.multiply(lotteries.size()));
    }
}
