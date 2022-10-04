package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {this.numbers = numbers;}

    public int findMatchingNum(List<Integer> winningNum) {
        return (int) numbers.stream().filter(winningNum::contains).count();
    }
}
