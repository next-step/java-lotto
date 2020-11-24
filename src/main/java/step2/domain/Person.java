package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Lotto> lottos = new ArrayList<>();
    private int[][] winCounts = new int[][]{{0, 5000}, {0, 50000}, {0, 1500000}, {0, 2000000000}};

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int[][] getWin(int[] winNumbers) {
        for (int i = 0; i < this.lottos.size(); i++) {
            checkWin(winNumbers, i);
        }
        return winCounts;
    }

    private void checkWin(int[] winNumbers, int i) {
        int equalCount = 0;
        for (int winNumber : winNumbers) {
            if (this.lottos.get(i).getNumbers().contains(winNumber)) {
                equalCount++;
            }
        }
        if (equalCount >= 3) {
            winCounts[equalCount - 3][0]++;
        }
    }

    public double getTotalRevenue(int purchasePrice) {
        int total = 0;
        for (int i = 0; i < winCounts.length; i++) {
            total = total + winCounts[i][0] * winCounts[i][1];
        }
        return (total / purchasePrice) * 100;
    }
}
