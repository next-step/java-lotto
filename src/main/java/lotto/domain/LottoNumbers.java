package lotto.domain;

import java.util.*;

public class LottoNumbers {
    private static final int NUMBERS_SIZE = 6;
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> generatedNumbers) {
        validateDuplicate(generatedNumbers);
        validateSize(generatedNumbers);
        this.numbers = new ArrayList<>();

        for (int number : generatedNumbers) {
            this.numbers.add(new LottoNumber(number));
        }
    }

    private void validateDuplicate(List<Integer> generatedNumbers) {
        Set<Integer> numbersSet = new HashSet<>(generatedNumbers);

        if(numbersSet.size() != generatedNumbers.size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    private void validateSize(List<Integer> generatedNumbers) {
        if(generatedNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다. : " + generatedNumbers.size());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
