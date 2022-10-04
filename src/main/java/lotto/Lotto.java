package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {this.numbers = numbers;}

    public String printNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            stringBuilder.append(number +", ");
        }
        stringBuilder.replace(stringBuilder.length()-2, stringBuilder.length()-1, "");
        return stringBuilder.toString();
    }
    public int findMatchingCount(List<Integer> winningNum) {
        return (int) numbers.stream().filter(winningNum::contains).count();
    }
}
