package Lotto;

import java.util.List;

public class PrizeNumbers {

    private List<Integer> prizeList;
    private Integer bonusNumber;

    public PrizeNumbers() {}

    public PrizeNumbers(List<Integer> prizeList, int bonusNumber) {
        this.prizeList = prizeList;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getPrizeList() {
        return this.prizeList;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

}
