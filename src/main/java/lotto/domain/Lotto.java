package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        validateLottoNumberDuplicate(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    private int addContainsCount(int currentCount, LottoNumber number) {
        return lottoNumbers.contains(number) ? currentCount + 1 : currentCount;
    }

    public int getContainCount(List<LottoNumber> numbers) {
        int count = 0;
        for(LottoNumber number : numbers) {
            count = addContainsCount(count, number);
        }
        return count;
    }

    private void validateLottoNumberDuplicate(final List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
        }
    }

    private void validateLottoNumberCount(final List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }

    @Override
    public String toString() {
        List<String> lottoNumberText = lottoNumbers.stream().map(String::valueOf).collect(Collectors.toList());
        return "[" + String.join(", ", lottoNumberText) + "]";
    }

    public LottoRank getWinningRank(WinningLotto winningLotto) {
        int containCount = winningLotto.getContainCount(this);
        return LottoRank.getRank(containCount, winningLotto.isContainBonus(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
