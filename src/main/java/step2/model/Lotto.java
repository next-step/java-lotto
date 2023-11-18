package step2.model;

import java.util.List;

public class Lotto {

    public static final int EACH_LOTTO_PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("로또 번호가 없습니다.");
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개가 되어야 합니다.");
        }
    }

    public int getLottoWinner(List<Integer> winNumbers) {
        int totalCount = 0;
        for (int winNumber : winNumbers) {
            if (this.numbers.contains(winNumber)) totalCount++;
        }

        return totalCount;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
