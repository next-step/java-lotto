package lotto.domain;

public class WinLotto {
    private final Numbers numbers;

    public WinLotto(String inputString) {
        numbers = new Numbers(inputString);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Numbers numbers() {
        return numbers;
    }

    public Integer findNumber(int i) {
        return numbers.find(i);
    }
}
