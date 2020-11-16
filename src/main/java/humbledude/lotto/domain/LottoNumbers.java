package humbledude.lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_SIZE_OF_NUMBERS = 6;

    private final Set<LottoNumber> numbers;

    private LottoNumbers(Set<LottoNumber> numbers) {
        validateNumbers(numbers);
    }

    public static LottoNumbers of(Set<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        return new LottoNumbers(lottoNumbers);
    }


    public Set<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("로또는 겹치지 않는 6개 숫자로만 만들수 있어요");
        }
    }

}
