package step2_bak;

import java.util.Set;

public class Winning {
    private Set<Integer>numbers;

    public Winning (Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }
}
