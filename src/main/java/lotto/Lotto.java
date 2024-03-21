package lotto;


public class Lotto {

    private Numbers numbers;

    public Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public LottoResult match(Numbers winningNumbers) {
        return new LottoResult(numbers.matchNumberCount(winningNumbers));
    }

}
