package lotto.domain.lotto.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<LottoNumber> lottoNumberses = new ArrayList<>();

    public LottoNumbers() {
    }

    public LottoNumbers(List<Integer> numbers) {
        validateAmountOfNumbers(numbers);

        numbers.forEach(number -> lottoNumberses.add(new LottoNumber(number)));
    }

    private void validateAmountOfNumbers(List<Integer> numbers) {
        if (removeDuplicate(numbers).size() != 6) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개가 입력되어야 합니다.");
        }
    }

    private List<Integer> removeDuplicate(List<Integer> inputs) {
        return inputs.stream()
            .distinct()
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> numbers() {
        return lottoNumberses.stream()
            .map(LottoNumber::number)
            .collect(Collectors.toUnmodifiableList());
    }

    public int countMatchingNumbers(LottoNumbers target) {
        return (int) lottoNumberses.stream()
            .filter(target::contains)
            .count();
    }

    private boolean contains(LottoNumber target) {
        return this.lottoNumberses.contains(target);
    }

    @Override
    public String toString() {
        return numbers().toString();
    }
}
