package kr.heesu.lotto.domain;

import kr.heesu.lotto.utils.LottoFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class MultipleLotto {

    private final PurchaseAmount amount;
    private List<Lotto> multipleLotto;

    private MultipleLotto(List<Lotto> lottos, PurchaseAmount amount) {
        this.multipleLotto = lottos;
        this.amount = amount;
    }

    public LottoResult matches(WinningNumbers winningNumbers) {
        Map<Long, Long> matches = multipleLotto.stream()
                .map(lotto -> lotto.match(winningNumbers.getWinningNumbers()))
                .collect(Collectors.groupingBy(Function.identity(), counting()));

        return LottoResult.of(matches, this.amount);
    }

    @Override
    public String toString() {
        return this.multipleLotto.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public static MultipleLotto of(PurchaseAmount amount) {
        List<Lotto> lottos = Stream.generate(LottoFactory::generateLottoNumbers)
                .limit(amount.getSize())
                .map(LottoFactory::createLotto)
                .collect(Collectors.toList());

        return new MultipleLotto(lottos, amount);
    }
}
