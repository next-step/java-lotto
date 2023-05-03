package lotto.domain;

public class WinLotto {
    private final Numbers numbers;

    public WinLotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers numbers() {
        return numbers;
    }

    public Integer findNumber(int i) {
        return numbers.find(i);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
