package view;

import domain.Number;

import java.util.List;

public class LottoView {
    List<Number> numbers;

    public LottoView(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
