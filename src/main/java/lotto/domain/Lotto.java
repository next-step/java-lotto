package lotto.domain;

import lotto.domain.starategy.GetLottoNumbersStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int SIZE = 6;

    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        checkSize(lotto);
        checkDistinct(lotto);
        this.lotto = lotto;
    }

    private Lotto(String lottoString) {
        this(Arrays.stream(lottoString.split(","))
                .map(lottoNumberString -> LottoNumber.ofString(lottoNumberString))
                .collect(Collectors.toList()));
    }

    public static Lotto ofStrategy(GetLottoNumbersStrategy getLottoNumbersStrategy) {
        return new Lotto(getLottoNumbersStrategy.getLotto());
    }

    public static Lotto ofString(String lottoString) {
        return new Lotto(lottoString);
    }

    private void checkSize(List<LottoNumber> lottoLottoNumbers) {
        if (lottoLottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
        }
    }

    private void checkDistinct(List<LottoNumber> lotto) {
        int compareSize = Long.valueOf(lotto.stream()
                .distinct()
                .count()).intValue();
        if (compareSize != lotto.size()) {
            throw new IllegalArgumentException("로또에 중복된 숫자가 존재합니다.");
        }
    }

    public int checkMatching(WinningLotto winningLotto) {
        Long count = lotto.stream()
                .filter(winningLotto::checkContainNumber)
                .count();
        return count.intValue();
    }

    public boolean checkContainNumber(LottoNumber bonusBall) {
        return lotto.contains(bonusBall);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lotto);
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
