package lotto.domain;

import lotto.domain.type.Rank;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public abstract class Lotto {
    public static final int PRICE = 1000;

    public static final int LOTTO_SIZE = 6;
    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 6개 이어야 합니다.";

    private final List<LottoNumber> lottoNumbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Rank rank(Lotto other, LottoNumber bonusNumber) {
        boolean matchBonus = lottoNumbers.contains(bonusNumber);

        return Rank.findRank(matchCount(other), matchBonus);
    }

    private int matchCount(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other.lottoNumbers::contains)
                .count();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public abstract boolean isAuto();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
