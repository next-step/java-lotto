package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 01:05
 */
public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개로 이루어져야 합니다.");
        }

        if (lottoNumbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복이 불가능 합니다.");
        }

        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::of).collect(Collectors.toList());
    }

    public static final Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private boolean contains(LottoNumber number) {
        return this.lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(number));
    }

    public Long match(Lotto userLotto) {
        return this.lottoNumbers.stream()
                .filter(lottoNumber -> userLotto.contains(lottoNumber)).count();
    }

    public List<Integer> getLottoNumber() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::convertIntValue)
                .collect(Collectors.toList());
    }

    public boolean matchBonusNo(LottoNumber bonusNo) {
        return contains(bonusNo);
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
