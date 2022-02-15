package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.budget.Budget;
import lotto.domain.lottonumber.LottoBalls;
import lotto.domain.lottonumber.LottoNumber;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottos(final List<String> inputManualLottoNumbers, final Budget budget) {
        final Budget autoLottoBudget = budget.deductionPerLotto(inputManualLottoNumbers.size());
        List<Lotto> lottos = createManualLottos(inputManualLottoNumbers);
        lottos.addAll(createAutoLottos(autoLottoBudget.getNumberOfPurchase()));

        return new Lottos(Collections.unmodifiableList(lottos));
    }

    private static List<Lotto> createAutoLottos(final int numberOfLotto) {
        return Collections.unmodifiableList(
                IntStream.range(0, numberOfLotto)
                        .mapToObj(num -> new Lotto(createRandomNumbers()))
                        .collect(Collectors.toList()));
    }

    private static List<Lotto> createManualLottos(final List<String> inputManualLottoNumbers) {
        return inputManualLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private static Set<LottoNumber> createRandomNumbers() {
        return LottoBalls.getRandomLottoNumber();
    }

    public int size() {
        return this.lottos.size();
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(this.lottos);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
