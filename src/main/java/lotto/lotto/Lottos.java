package lotto.lotto;

import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.LottoResults;
import lotto.result.Rank;
import lotto.result.WinningNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos from(List<Lotto> values) {
        return new Lottos(values);
    }

    public static Lottos from(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < quantity; i++) {
            LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
            Lotto lotto = Lotto.from(lottoNumbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public LottoResults result(WinningNumbers winningNumbers, int purchaseAmount) {
        Map<Rank, Long> result = values.stream()
                .collect(groupingBy(winningNumbers::result, counting()));

        return LottoResults.from(result, purchaseAmount);
    }

    public List<Lotto> values() {
        return values;
    }

    public int quantity() {
        return values.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(values, lottos1.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
