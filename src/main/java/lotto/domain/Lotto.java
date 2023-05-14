package lotto.domain;

import lotto.dto.LottoDto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final Money LOTTO_AMOUNT = new Money(1_000L);
    private final List<LottoNumber> lottoNumbers;

    public Lotto(int... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateNoDuplication(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private void validateNoDuplication(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottos = new HashSet<>(lottoNumbers);
        if (lottos.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format("중복된 숫자는 입력할 수 없습니다. values=%s",lottoNumbers));
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
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

    public long countMatching(Lotto winningLotto) {
        return lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }
    public LottoDto toDto() {
        return lottoNumbers.stream()
                .map(LottoNumber::toInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoDto::new));
    }

    public boolean contains(LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }
}
