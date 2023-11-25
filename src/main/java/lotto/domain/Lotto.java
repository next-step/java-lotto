package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicates(lottoNumbers);
        this.lottoNumbers = convertLotto(lottoNumbers);
    }

    public static Lotto from(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto of(Integer... lottoNumber) {
        return new Lotto(Arrays.asList(lottoNumber));
    }

    public int calculateSameNumber(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contain)
                .count();
    }

    public boolean contain(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (!isValidSize(lottoNumbers)) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d자리여야합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    private void validateDuplicates(List<Integer> lottoNumbers) {
        if (hasDuplicates(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }

    private boolean isValidSize(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_NUMBER_COUNT;
    }

    private boolean hasDuplicates(List<Integer> lottoNumbers) {
        return Set.copyOf(lottoNumbers).size() != lottoNumbers.size();
    }

    private static List<LottoNumber> convertLotto(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
