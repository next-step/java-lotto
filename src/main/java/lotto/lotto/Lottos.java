package lotto.lotto;

import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.Rank;

import java.util.*;

import static java.util.stream.Collectors.*;

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

    public Map<Rank, Long> match(LottoNumbers winningNumbers) {
        return values.stream()
                .collect(groupingBy(lotto -> Rank.findBy(lotto.match(winningNumbers)),
                                counting())
                );


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
