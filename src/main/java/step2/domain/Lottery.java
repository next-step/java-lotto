package step2.domain;

import step2.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private static final int IS_MATCHED = 1;
    private static final int IS_NOT_MATCHED = 0;

    private List<Integer> selectedNumbers;

    public Lottery() {
        selectedNumbers = Util.getShuffled();
        Util.getSorted(selectedNumbers);
    }

    public Lottery(List<Integer> winningNumber) {
        Util.getSorted(winningNumber);
        this.selectedNumbers = winningNumber;
    }

    /**
     * 생성된 번호를 리턴하는 메소드
     * @return 생성된 번호
     */
    public List<Integer> getSelectedNumbers() {
        return this.selectedNumbers;
    }

    /**
     * 당첨 번호와 현재 복권을 매칭하는 메소드
     * @param winningLottery 당첨 로또 번호 ([1,2,3,4,5,6])
     */
    public int match(WinningLottery winningLottery) {
        int count = 0;

        for (int number : winningLottery.getWinningNumbers()) {
            count += this.compareNumber(number, this.selectedNumbers);
        }

        return count;
    }

    /**
     * 당첨 번호와 현재 복권의 번호들과 같은지 비교
     * @param number 당첨 번호 (1)
     * @param selectedNumbers 현재 복권의 숫자들 ([8, 21, 23, 41, 42, 43])
     */
    private int compareNumber(int number, List<Integer> selectedNumbers) {
        int count = 0;

        for (int selected : selectedNumbers) {
            count += getMatched(number, selected);
        }

        return count;
    }

    /***
     * 현재 복권의 숫자와 당첨 번호가 같은지 비교하는 메소드
     * @param number 당첨 번호 (1)
     * @param selected 현재 복권의 번호 (8)
     */
    private int getMatched(int number, int selected) {
        return (number == selected) ? IS_MATCHED : IS_NOT_MATCHED;
    }
}
