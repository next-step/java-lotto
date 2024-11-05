package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this(toLottoNumber(lottoNumbers));
    }

    // 주생성자
    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6자리로 구성되어야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> list = new ArrayList<>(lottoNumbers);
        list.sort(Comparator.comparingInt(LottoNumber::getValue));
        return unmodifiableList(list);
    }

    public int countMatchingNumbers(LottoNumbers otherLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(otherLottoNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber otherLottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.isSame(otherLottoNumber));
    }

    private static Set<LottoNumber> toLottoNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
