package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottery {
    public List<Integer> numbers;

    private Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lottery createLottery(List<Integer> numbers) {
        List<Integer> copyOfNumbers = new ArrayList<>(numbers);
        return new Lottery(copyOfNumbers);
    }

}
