package lotto.domain;

public class Lotto {

    private final LottoNumbers numbers;
    private int matchingCount = 0;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }
    public Lotto(LottoNumbers numbers, int matchingCount) {
        this.numbers = numbers;
        this.matchingCount = matchingCount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public void draw(Lotto luckyLotto) {
        this.matchingCount = numbers.matchingNumbers(luckyLotto);
    }

    public void print() {
        numbers.print();
    }

}
