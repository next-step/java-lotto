package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lottonumber.LottoBalls;
import lotto.domain.budget.Budget;
import lotto.domain.lottonumber.LottoNumber;

public class Lottos {

    private static final int PRICE_OF_LOTTO = 1000;

    private final List<Lotto> lottos;

    Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createAutoLottos(final Budget budget) {
        final List<Lotto> lottos = new ArrayList<>();

        final int numberOfLotto = budget.getNumberOfPurchase(PRICE_OF_LOTTO);
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(createRandomNumbers()));
        }
        return new Lottos(lottos);
    }

    private static Set<LottoNumber> createRandomNumbers() {
        return LottoBalls.getRandomLottoNumber();
    }

    public static Lottos createManualLottos(final List<String> inputManualLottoNumbers, final Budget budget) {
        budget.deduct(PRICE_OF_LOTTO * inputManualLottoNumbers.size());

        final List<Lotto> lottos = inputManualLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public Lottos merge(final Lottos target) {
        final List<Lotto> mergedLottos = Stream.concat(this.lottos.stream(), target.get().stream())
                .collect(Collectors.toList());

        return new Lottos(mergedLottos);

    }

    public List<Lotto> get() {
        return this.lottos;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
