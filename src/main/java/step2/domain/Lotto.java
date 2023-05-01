package step2.domain;


import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getResult(List<Integer> winningNumbers) {
        int numberOfMatched = 0;
        for (Integer winningNumber : winningNumbers) {
            numberOfMatched += numbers.contains(winningNumber)? 1 : 0;
        }
        return numberOfMatched;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            stringBuilder.append(numbers.get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.append(numbers.get(numbers.size() - 1));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}