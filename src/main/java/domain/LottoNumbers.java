package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    public final static int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateNumberCount(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers create(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public int match(LottoNumbers comparingNumbers) {
        Set<LottoNumber> mergedLottoNumbers = mergeIntoSet(comparingNumbers);
        return 2 * LOTTO_NUMBER_COUNT - mergedLottoNumbers.size();
    }

    public List<LottoNumber> toList() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> noDuplicateLottoNumbers = new HashSet<>(lottoNumbers);
        if (noDuplicateLottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    private Set<LottoNumber> mergeIntoSet(LottoNumbers lottoNumbers) {
        Set<LottoNumber> mergedLottoNumbers = new HashSet<>();
        mergedLottoNumbers.addAll(lottoNumbers.toList());
        mergedLottoNumbers.addAll(this.lottoNumbers);
        return mergedLottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
