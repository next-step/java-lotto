package lotto.domain;

import lotto.generator.NumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_SIZE = 6;

    private final Set<LottoNumber> lotto;

    private Lotto(final Set<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public static Lotto from(final NumberGenerator numberGenerator) {
        return numberGenerator.generator().stream()
                .map(LottoNumber::from)
                .collect(collectingAndThen(toSet(),
                        Lotto::new));
    }

    public static Lotto from(final List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        return lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(collectingAndThen(toSet(),
                        Lotto::new));
    }

    private static void validateLottoNumbers(final List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %s자리 이어야 합니다.", NUMBER_SIZE));
        }
        if (new HashSet<>(lottoNumbers).size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 로또 번호는 입력할 수 없습니다.");
        }
    }

    public int getMatchCount(final Lotto winningLotto) {
        return (int) winningLotto.getLotto().stream()
                .filter(lottoNumber -> this.lotto.contains(lottoNumber))
                .count();
    }

    public boolean matchBonus(final LottoNumber bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(lotto);
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
}
