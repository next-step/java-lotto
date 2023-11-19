package lotto.domain.lotto.wrapper;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int AMOUNT_OF_NUMBERS = 6;

    private final TreeSet<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<Integer> lottoNumbers) {
        validateAmountOfNumbers(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toCollection(TreeSet::new));
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
    }

    private void validateAmountOfNumbers(Set<Integer> numbers) {
        if (numbers.size() != AMOUNT_OF_NUMBERS) {
            throw new IllegalArgumentException(String.format("로또 당첨 번호는 %d개가 입력되어야 합니다.", AMOUNT_OF_NUMBERS));
        }
    }

    public List<Integer> numbers() {
        return lottoNumbers.stream()
            .map(LottoNumber::number)
            .collect(Collectors.toUnmodifiableList());
    }

    public int countMatchingNumbers(LottoNumbers target) {
        return (int) lottoNumbers.stream()
            .filter(target::contains)
            .count();
    }

    public boolean contains(LottoNumber target) {
        return this.lottoNumbers.contains(target);
    }

    @Override
    public String toString() {
        return numbers().toString();
    }
}
