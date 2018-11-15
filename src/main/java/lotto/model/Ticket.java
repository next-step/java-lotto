package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    public static final int PRICE = 1_000;
    private List<LottoNum> nums;

    public Ticket(List<LottoNum> nums) {
        this.nums = nums;
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
                    return LottoNum.toInteger(nums).contains(i.getNum());
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
        return LottoNum.toInteger(nums)
                .contains(bonusNum.getNum());
    }

    /**
     * 티켓 번호들 가져오기
     * @param tickets
     * @return
     */
    public static List<String> getTicketsNums(List<Ticket> tickets) {
        return tickets.stream()
                .map(Ticket::getNums)
                .map(LottoNum::toInteger)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
