package step2;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = sortLottoNumbers(lottoNumbers);
    }

    public static Lotto of(List<Integer> rawLottoNumbers) {
        List<LottoNumber> lottoNumbers = rawLottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            System.out.println(lottoNumbers);
            throw new RuntimeException("로또의 숫자가 6개가 아닙니다.");
        }
        if (new HashSet<>(lottoNumbers).size() != LOTTO_NUMBER_COUNT) {
            throw new RuntimeException("로또의 숫자가 중복입니다.");
        }
    }

    private List<LottoNumber> sortLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toList());
    }

    public int getMatchCount(Lotto otherLotto) {
        return (int) lottoNumbers.stream()
                .filter(otherLotto.lottoNumbers::contains)
                .count();
    }

    List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
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
        return Objects.hashCode(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
