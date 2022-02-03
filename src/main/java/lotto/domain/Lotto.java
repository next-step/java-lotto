package lotto.domain;


import java.util.List;

public class Lotto {

    private final List<String> numbers;

    public Lotto(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> get() {
        return this.numbers;
    }
}
