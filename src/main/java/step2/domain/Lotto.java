package step2.domain;

import java.util.List;

public class Lotto {

    private final PickedNumber pickedNumbers;
    private Ranking ranking;

    public Lotto(List<Integer> pickedNumbers) {
        this.pickedNumbers = new PickedNumber(pickedNumbers);
    }

    private Lotto() {
        TotalNumbers totalNumbers = new TotalNumbers();
        List<Integer> numbers = totalNumbers.getRandomNumber();
        this.pickedNumbers = new PickedNumber(numbers);
    }

    public static Lotto issue() {
        return new Lotto();
    }

    public List<Integer> getNumbers() {
        return this.pickedNumbers.get();
    }

    public void rank(Ranking ranking) {
        this.ranking = ranking;
    }

    public int getPrizedMoney() {
        return this.ranking.getWinningMoney();
    }

    public Ranking getRanking() {
        return ranking;
    }
}

