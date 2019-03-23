package domain;

public class Winning extends Lotto {

    public Winning(String numbers) {
        super(numbers);
    }

    public int compare(Lotto lotto) {
        return (int) this.numbers.stream().filter(lotto::contains).count();
    }
}
