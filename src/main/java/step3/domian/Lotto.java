package step3.domian;

import step3.domian.LastWinner;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
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