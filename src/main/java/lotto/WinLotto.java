package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {

    List<Integer> winningNumbers;
    int bonus;

    public WinLotto(List<Integer> winningNumbers, int bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public int checkLotto(Lotto lotto) {
        return lotto.getMatchCount(getAllNumbers());
    }

    public boolean hasBonus(Lotto lotto) {
        return lotto.hasNumber(bonus);
    }

    private List<Integer> getAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(this.winningNumbers);
        numbers.add(bonus);
        return numbers;
    }

}
