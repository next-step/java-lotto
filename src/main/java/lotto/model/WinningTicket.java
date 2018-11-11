package lotto.model;

import java.util.List;

public class WinningTicket {
    private List<Integer> nums;
    private Integer bonusNum;

    public WinningTicket(List<Integer> nums, Integer bonusNum) {
        this.nums = nums;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }
}
