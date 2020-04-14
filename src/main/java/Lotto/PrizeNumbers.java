package Lotto;

import java.util.List;

public class PrizeNumbers {

    private List<Integer> prizeStorage;
    private Integer bonusNumber;

    public PrizeNumbers() {}

    public PrizeNumbers(List<Integer> prizeStorage, int bonusNumber) {
        this.prizeStorage = prizeStorage;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getPrizeStorage() {
        return this.prizeStorage;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

}
