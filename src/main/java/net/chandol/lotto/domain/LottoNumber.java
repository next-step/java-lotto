package net.chandol.lotto.domain;

import java.util.List;

import static com.google.common.primitives.Ints.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static net.chandol.lotto.util.LottoNumberValidator.validateNumbersRange;
import static net.chandol.lotto.util.LottoNumberValidator.validateUniqueNumbers;
import static net.chandol.lotto.util.RandomLottoNumberProvider.getNumbers;

public class LottoNumber {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private List<Integer> numbers;

    // static factory method 만을 사용하도록 만들자!
    private LottoNumber(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return unmodifiableList(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateUniqueNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자를 확인해주세요.");
        }
    }

    public List<Integer> getMatchNumbers(LottoNumber another) {
        return another.getLottoNumbers().stream()
                .filter(i -> numbers.contains(i))
                .collect(toList());
    }

    public Integer getMatchSize(LottoNumber another) {
        return getMatchNumbers(another).size();
    }

    public boolean containsNumber(Integer bonusNumber) {
        return this.getLottoNumbers().contains(bonusNumber);
    }

    public static LottoNumber direct(List<Integer> numbers) {
        return new LottoNumber(numbers);
    }

    public static LottoNumber direct(int n1, int n2, int n3, int n4, int n5, int n6) {
        return new LottoNumber(asList(n1, n2, n3, n4, n5, n6));
    }

    public static LottoNumber auto() {
        return new LottoNumber(getNumbers());
    }
}
