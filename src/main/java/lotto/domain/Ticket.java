package lotto.domain;

public class Ticket {
    public static final int PRICE = 1000;
    private Numbers numbers = new Numbers();

    public Ticket() {
    }

    public Ticket(Numbers numbers) {
        this.numbers = numbers;
    }

    public long match(Numbers winneingNumbers) {
        return this.numbers.compareNumbers(winneingNumbers).stream().filter(m -> m).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
