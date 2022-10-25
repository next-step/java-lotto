package step4.domian;

import java.util.List;

public class LastWinner {
    private final List<Integer> numbers;
    private final int bonus;

    public LastWinner(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public int countSameNumber(Lotto lotto) {
        int sameCount = 0;
        for (int num : this.numbers) {
            sameCount += lotto.isContain(num);
        }
        return sameCount;
    }

    public boolean isContainBonus(Lotto lotto) {
        if (lotto.isContain(this.bonus) == 1) {
            return true;
        }
        return false;
    }
}