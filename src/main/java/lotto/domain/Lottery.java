package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottery {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private LottoNumbers lottoNumbers;

    public Lottery(final String input) {
        this.lottoNumbers = new LottoNumbers(newInstanceFromInput(input));
    }

    public Lottery(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    private List<LottoNumber> newInstanceFromInput(final String input) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String letter : input.split(LOTTO_NUMBER_DELIMITER)) {
            LottoNumber lottoNumber = LottoNumber.valueOf(Integer.valueOf(letter));
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lottery lottery = (Lottery) o;
        return Objects.equals(lottoNumbers, lottery.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
