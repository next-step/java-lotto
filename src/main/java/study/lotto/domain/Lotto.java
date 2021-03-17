package study.lotto.domain;

import study.lotto.generator.LottoNumberGenerator;
import study.lotto.generator.NumberGenerator;
import study.lotto.view.dto.RequestWinningNumber;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<LottoNumber> lotto;

    public Lotto() {
        this(new LottoNumberGenerator());
    }

    public Lotto(final NumberGenerator lottoGenerator) {
        lotto = lottoGenerator.generate();
    }

    public long winningReward(RequestWinningNumber requestWinningNumber) {
        return match(requestWinningNumber).getWinningReward();
    }

    public LottoMatch match(final RequestWinningNumber winningNumber) {
        List<LottoNumber> winningNumbers = winningNumber.getWinningNumbers();

        long count = lotto.stream()
                .filter(winningNumbers::contains)
                .count();

        return LottoMatch.of(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return String.valueOf(lotto);
    }
}
