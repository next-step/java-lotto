package step2.model;

import static step2.model.LottoValidator.*;

public class Bonus {
    private int bonusNumber;

    public Bonus(String bonus) {
        isValid(bonus);
        this.bonusNumber = Integer.parseInt(bonus.trim());
    }

    private void isValid(String bonus) {
        isBlank(bonus);
        isDigit(bonus);
        isInRange(bonus);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
