package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_SIZE = 6;
    private List<Number> numbers;

    private LottoNumbers(List<Integer> inputNumbers) {
        List<Number> list = inputNumbers.stream().map(Number::createInstance).collect(Collectors.toList());
        this.numbers = list;
    }

    public static LottoNumbers createInstance(List<Integer> inputNumbers) {
        if (inputNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        return new LottoNumbers(inputNumbers);
    }

    public boolean contains(Number number) {
        return numbers.stream().map(num -> num.equals(number)).anyMatch(num -> num.equals(true));
    }

    public String toString() {
        StringBuffer resultString = new StringBuffer();
        resultString.append("[");
        numbers.forEach(number -> resultString.append(number.toString()+" "));
        resultString.append("]");
        return resultString.toString();
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
