package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validateLottoNumberSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(List<Integer> givenLottoNumbers) {
        this(givenLottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public Lotto(int[] givenLottoNumbers) {
        this(Arrays.stream(givenLottoNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    private void validateLottoNumberSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 한 장은 6장의 숫자가 있어야합니다.");
        }
    }

    public Integer compareToMatchNumberCount(Lotto other) {
        return Math.toIntExact(this.lottoNumbers.stream()
                .filter(other::containsLottoNumber)
                .count());
    }

    public boolean containsLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public List<Integer> printLotto() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList());
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
