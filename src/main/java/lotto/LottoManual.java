package lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManual implements Lotto {
    private Set<LottoNumber> lotto;

    private LottoManual(String lotto) {
        Set<Integer> lottoSet = Arrays.stream(lotto.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        if (lottoSet.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.lotto = Lotto.makeLottoNumberSet(lottoSet.stream());
    }

    public static LottoManual of(String stringLottoNumber) {
        return new LottoManual(stringLottoNumber);
    }

    @Override
    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public int match(Lotto winningLotto) {
        return (int) this.lotto.stream()
                .filter(winningLotto::contains)
                .count();
    }

    @Override
    public boolean contains(LottoNumber lottoNumber) {
        return this.lotto.contains(lottoNumber);
    }
}
