package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.domain.budget.Budget;
import lotto.domain.lottonumber.LottoBalls;
import lotto.domain.lottonumber.LottoNumber;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createAutoLottos(final Budget budget) {
        final int numberOfLotto = budget.getNumberOfPurchase();

        return new Lottos(Collections.unmodifiableList(
                IntStream.range(0, numberOfLotto)
                        .mapToObj(num -> new Lotto(createRandomNumbers()))
                        .collect(Collectors.toList())));
    }

    private static Set<LottoNumber> createRandomNumbers() {
        return LottoBalls.getRandomLottoNumber();
    }

    public static Lottos createManualLottos(final List<String> inputManualLottoNumbers) {
        return new Lottos(Collections.unmodifiableList(
                inputManualLottoNumbers.stream()
                        .map(Lotto::new)
                        .collect(Collectors.toList())));
    }

    public int size() {
        return this.lottos.size();
    }

    public Lottos merge(final Lottos target) {
        return new Lottos(Collections.unmodifiableList(
                Stream.concat(this.lottos.stream(), target.get().stream())
                        .collect(Collectors.toList())));
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(this.lottos);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
