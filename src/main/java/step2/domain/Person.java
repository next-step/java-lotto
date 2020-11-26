package step2.domain;

import java.util.List;
import java.util.Set;

public class Person {
    public int[][] getWin(int[] winNumbers, List<Lotto> lottos) {
        int[][] winCounts = new int[][]{{0, 5000}, {0, 50000}, {0, 1500000}, {0, 2000000000}};

        for (int i = 0; i < lottos.size(); i++) {
            checkWin(winNumbers, winCounts, lottos.get(i).getNumbers());
        }
        return winCounts;
    }

    private void checkWin(int[] winNumbers, int[][] winCounts, Set<LottoNumber> lottoNumber) {
        int equalCount = 0;
        for (int winNumber : winNumbers) {
            if (lottoNumber.contains(winNumber)) {
                equalCount++;
            }
        }
        if (equalCount >= 3) {
            winCounts[equalCount - 3][0]++;
        }
    }

    public double getTotalRevenue(int purchasePrice, int[][] winCounts) {
        double total = 0;
        for (int i = 0; i < winCounts.length; i++) {
            total = total + winCounts[i][0] * winCounts[i][1];
        }
        return (total / purchasePrice) * 100;
    }
}
