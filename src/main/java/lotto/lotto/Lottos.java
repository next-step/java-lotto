package lotto.lotto;

import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.LottoResults;
import lotto.result.MatchedNumbersCount;

import java.util.*;

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

    public LottoResults result(LottoNumbers winningNumbers, int purchaseAmount) {
        Map<MatchedNumbersCount, Long> lottoResults = new EnumMap<>(MatchedNumbersCount.class);

        for (MatchedNumbersCount matchedNumbersCount : MatchedNumbersCount.values()) {
            long matchedLottosCount = match(winningNumbers, matchedNumbersCount);
            lottoResults.put(matchedNumbersCount, matchedLottosCount);
        }

        return LottoResults.from(lottoResults, purchaseAmount);
    }

    private long match(LottoNumbers winningNumbers, MatchedNumbersCount matchedNumbersCount) {
        return values.stream()
                .filter(lotto -> lotto.match(winningNumbers, matchedNumbersCount::isEqualsTo))
                .count();
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
