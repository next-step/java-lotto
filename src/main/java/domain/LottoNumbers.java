package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private List<Number> numbers;

    public LottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        this.numbers = numbers.stream().map(Number::new).collect(Collectors.toList());
    }

    public boolean contains(int number) {
        return numbers.stream().map(num -> num.numberCompare(number)).collect(Collectors.toList())
                .contains(true);
    }

    public String toString() {
        StringBuffer resultString = new StringBuffer();
        resultString.append("[");
        numbers.forEach(number -> resultString.append(number.toString()+" "));
        resultString.append("]");
        return resultString.toString();
    }
}
