package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningStats {
    public static final int TOTAL_WINNING_COUNTS = 4; // 3개, 4개, 5개, 6개 총 4가지 케이스

    private final List<Integer> winningNumbers; // 사용자로부터 입력받는 값.
    private final List<Integer> winningStats;
    private final Lotto lotto;
    private final int[] winningCounts = new int[TOTAL_WINNING_COUNTS];


    public LottoWinningStats(List<Integer> winningNumbers, Lotto lotto) {
        this.winningNumbers = winningNumbers;
        this.lotto = lotto;
        this.winningStats = new ArrayList<>(lotto.getNumbersSize());
    }

    public void calculateWinningStats() {
        // 로또 객체를 기반으로 당첨 통계 계산
        for (int i=0 ; i<lotto.getNumbersSize() ; i++) {
            List<Integer> targetNumbers = lotto.getNumbers().get(i);
            winningStats.add(i, getCount(targetNumbers));
        }
    }

    private int getCount(List<Integer> targetNumbers) {
        int count = 0;
        for (Integer winningNumber : winningNumbers) {
            count = checkCount(targetNumbers, winningNumber, count);
        }
        return count;
    }

    private int checkCount(List<Integer> targetNumbers, Integer winningNumber, int count) {
        if (targetNumbers.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    public void calculateWinningCounts() {
        for (int targetCount : this.winningStats) {
            countByCase(targetCount);
        }
    }

    private void countByCase(int targetCount) {
        if (targetCount == 3) {
            winningCounts[0]++;
            return;
        }
        if (targetCount == 4) {
            winningCounts[1]++;
            return;
        }
        if (targetCount == 5) {
            winningCounts[2]++;
            return;
        }
        if (targetCount == 6) {
            winningCounts[3]++;
        }
    }

    public void printWinningCounts() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)-" + winningCounts[0] + " 개");
        System.out.println("4개 일치 (50000원)-" + winningCounts[1] + " 개");
        System.out.println("5개 일치 (1500000원)-" + winningCounts[2] + " 개");
        System.out.println("6개 일치 (2000000000원)-" + winningCounts[3] + " 개");
    }

    public double getYield() {
        int totalAmounts = this.lotto.getPurchaseCount() * Lotto.AMOUNT;
        int totalWinningAmounts = (5000 * winningCounts[0] + 50000 * winningCounts[1] + 1500000 * winningCounts[2] + 2000000000 * winningCounts[3]);
        if (totalWinningAmounts == 0) {
            return 0;
        }
        return (double) totalWinningAmounts / totalAmounts;
    }

    public List<Integer> getWinningNumbers() { return this.winningNumbers; }
    public List<Integer> getWinningStats() { return this.winningStats; }
    public int[] getWinningCounts() { return this.winningCounts; }
}
