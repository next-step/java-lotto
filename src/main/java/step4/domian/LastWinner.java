package step4.domian;

import java.util.List;

public class LastWinner {
    private final List<Integer> numbers;
    private final int bonus;

    public LastWinner(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public Prize getPrizeByComparingWithLotto(Lotto lotto) {
        int count = countSameNumber(lotto);
        return Prize.getPrize(count, checkBonus(count, lotto));
    }

    private boolean checkBonus(int count, Lotto lotto) {
        if (count == 5) {
            return lotto.isContain(this.bonus) == 1;
        }
        return false;
    }

    private int countSameNumber(Lotto lotto) {
        int sameCount = 0;
        for (int num : this.numbers) {
            sameCount += lotto.isContain(num);
        }
        return sameCount;
    }

}