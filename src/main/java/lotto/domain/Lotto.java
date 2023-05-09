package lotto.domain;

import lotto.dto.LottoDto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final Money LOTTO_AMOUNT = new Money(1_000L);
    private final List<LottoNumber> lottoNumbers;

    public Lotto(int... lottoNumbers) {
        this.lottoNumbers = Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
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

    public Rank countMatching(Lotto winningLotto, LottoNumber bonus) {
        return Rank.of(winningLotto.lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count(), hasBonus(bonus));
    }

    private boolean hasBonus(LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }

    public LottoDto toDto() {
        return lottoNumbers.stream()
                .map(LottoNumber::toInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoDto::new));
    }
}
