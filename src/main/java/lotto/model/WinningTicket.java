package lotto.model;

import java.util.List;

public class WinningTicket {
    private List<LottoNum> nums;
    private LottoNum bonusNum;

    public WinningTicket(List<LottoNum> nums, LottoNum bonusNum) {
        this.nums = nums;
        this.bonusNum = bonusNum;
    }

    public List<LottoNum> getNums() {
        return nums;
    }

    public LottoNum getBonusNum() {
        return bonusNum;
    }
}
