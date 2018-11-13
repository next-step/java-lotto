package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    public static final int PRICE = 1_000;
    private List<LottoNum> nums;
    private boolean isAuto;

    public Ticket(List<LottoNum> nums, boolean isAuto) {
        this.nums = nums;
        this.isAuto = isAuto;
    }

    public List<LottoNum> getNums() {
        return nums;
    }

    /**
     * 당첨번호와 일치한 번호 갯수
     *
     * @param lotteryNums
     * @return
     */
    public int countMatch(List<LottoNum> lotteryNums) {
        return (int) lotteryNums.stream()
                .filter(i -> {
                    return toInteger(nums).contains(i.getNum());
                })
                .count();
    }

    /**
     * 보너스 번호 있는지 여부
     *
     * @param bonusNum
     * @return
     */
    public boolean hasBonusNum(LottoNum bonusNum) {
        return toInteger(nums)
                .contains(bonusNum.getNum());
    }

    /**
     * 자동인지 여부
     *
     * @return
     */
    public boolean isAuto() {
        return isAuto;
    }

    /**
     * Integer로 변환
     *
     * @param lottoNums
     * @return
     */
    public static List<Integer> toInteger(List<LottoNum> lottoNums) {
        return lottoNums.stream()
                .map(LottoNum::getNum)
                .collect(Collectors.toList());
    }
}
