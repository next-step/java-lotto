package step2.domain;

import step2.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private static final int INIT_MATCHED = 0;

    private List<Integer> selectedNumbers = new ArrayList<>();
    private int matched;

    public Lottery() {
        selectedNumbers = Util.getShuffled();
        Util.getSorted(selectedNumbers);
        this.matched = INIT_MATCHED;
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
     * @param winningLottery 당첨 로또 번호
     */
    public void match(WinningLottery winningLottery) {
        for (int number : winningLottery.getWinningNumbers()) {
            this.compareNumber(number, this.selectedNumbers);
        }
    }

    /**
     * 당첨 번호와 현재 복권의 번호들과 같은지 비교
     * @param number 당첨 번호
     * @param selectedNumbers 현재 복권의 숫자들
     */
    private void compareNumber(int number, List<Integer> selectedNumbers) {
        for (int selected : selectedNumbers) {
            isEqual(number, selected);
        }
    }

    /***
     * 현재 복권의 숫자와 당첨 번호가 같은지 비교하는 메소드
     * @param number 당첨 번호
     * @param selected 현재 복권의 번호
     */
    private void isEqual(int number, int selected) {
        if (number == selected) {
            this.matched++;
        }
    }

    /**
     * 개별 로또의 일치하는 갯수 반환하는 메소드
     * @return 일치하는 숫자 갯수
     */
    public int getMatched() {
        return this.matched;
    }
}
