package step3.domian;

import step3.domian.LastWinner;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("번호의 갯수가 잘못되었습니다.");
        }
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int countSameNumber(LastWinner lastWinner) {
        int sameCount = 0;
        for (int num : lastWinner.numbers) {
            sameCount += isContain(num);
        }
        return sameCount;
    }

    public int isContain(int num) {
        if (this.numbers.contains(num)) {
            return 1;
        }
        return 0;
    }
}