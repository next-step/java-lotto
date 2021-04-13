package lotto.domain;

import java.util.List;

public class LottoNumber {

    private List<Number> numbers;

    public LottoNumber(List<Number> numbers) {
        this.numbers = numbers;

    }

    public List<Number> numbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (Number number : this.numbers) {
            output.append(number.number() + ",");
        }
        output.delete(output.length() - 1, output.length());
        output.append("]");
        return output.toString();
    }
}
