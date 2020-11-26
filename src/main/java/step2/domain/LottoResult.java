package step2.domain;

import java.util.List;

public class LottoResult {
    public int[][] getWin(int[] winNumbers, List<Lotto> lottoList) {
        int[][] winCounts = new int[][]{{0, 5000}, {0, 50000}, {0, 1500000}, {0, 2000000000}};

        for (int i = 0; i < lottoList.size(); i++) {
            checkWin(winNumbers, winCounts, lottoList.get(i));
        }
        return winCounts;
    }

    private void checkWin(int[] winNumbers, int[][] winCounts, Lotto lotto) {
        int equalCount = 0;
        for (int winNumber : winNumbers) {
            equalCount += lotto.contains(winNumber) ? 1 : 0;
        }
        if (equalCount >= 3) {
            winCounts[equalCount - 3][0]++;
        }
    }

    public double getTotalRevenue(int purchasePrice, int[][] winCounts) {
        double total = 0;
        for (int i = 0; i < winCounts.length; i++) {
            total = total + (winCounts[i][0] * winCounts[i][1]);
        }
        return (total / purchasePrice);
    }
}
