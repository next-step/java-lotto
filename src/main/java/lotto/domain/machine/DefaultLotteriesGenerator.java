package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLotteriesGenerator implements LotteriesGenerator {
    @Override
    public List<Lotto> generate(final Money amount, final List<LottoNumbers> numbers) {
        final List<Lotto> lotteries = issueManual(numbers);
        lotteries.addAll(issueAutomatic(getBalance(amount, lotteries)));
        return lotteries;
    }

    private List<Lotto> issueManual(final List<LottoNumbers> numbers) {
        return numbers.stream()
                .map(Lotto::manual)
                .collect(Collectors.toList())
                ;
    }

    private List<Lotto> issueAutomatic(final Money amount) {
        return IntStream.rangeClosed(1, getNumberOfLottoToPurchase(amount))
                .mapToObj(time -> Lotto.automatic())
                .collect(Collectors.toList())
                ;
    }

    private int getNumberOfLottoToPurchase(final Money amount) {
        return amount.divide(Lotto.PRICE)
                .intValue()
                ;
    }

    private Money getBalance(final Money amount, final List<Lotto> lotteries) {
        return amount.subtract(Lotto.PRICE.multiply(lotteries.size()));
    }
}
