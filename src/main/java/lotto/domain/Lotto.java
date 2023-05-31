package lotto.domain;

import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_PRICE = 1_000;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final String LOTTO_NUMBERS_SIZE_MUST_BE_EQUAL_TO_SIX = "로또 번호는 6개의 숫자로 구성되어야 합니다.";
    private final TreeSet<LottoNumber> lottoNumbers;

    public Lotto(TreeSet<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateLottoNumbers();
    }

    public void validateLottoNumbers() {
        if (isLottoNumbersSizeIsSix()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_MUST_BE_EQUAL_TO_SIX);
        }
    }

    private boolean isLottoNumbersSizeIsSix() {
        return lottoNumbers.size() != LOTTO_NUMBERS_SIZE;
    }

    public static Lotto createFromWinningNumbers(TreeSet<Integer> winningNumbers) {
        TreeSet<LottoNumber> lottoNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));

        return new Lotto(lottoNumbers);
    }

    public TreeSet<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
