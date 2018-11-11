package lotto.model;

import java.util.List;

public class Ticket {
    private List<Integer> nums;

    public Ticket(List<Integer> nums) {
        this.nums = nums;
    }

    public List<Integer> getNums() {
        return nums;
    }

    /**
     * 당첨번호와 일치한 번호 갯수
     * @param lotteryNums
     * @return
     */
    public int countMatch(List<Integer> lotteryNums) {
        return (int)lotteryNums.stream()
                .filter(i -> nums.contains(i))
                .count();
    }
}
