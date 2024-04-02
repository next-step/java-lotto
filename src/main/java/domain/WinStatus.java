package domain;

import java.util.ArrayList;
import java.util.List;

public class WinStatus {
    private static List<Integer> winCount;;
    private static final int VALID_WIN_COUNT = 3;

    public void correct(int count) {
        if (count >= VALID_WIN_COUNT) {
            int index = count - VALID_WIN_COUNT;
            winCount.set(index, winCount.get(index) + 1);
        }
    }

    public WinStatus() {
        winCount = new ArrayList<>();
        for (int i = 0; i <= VALID_WIN_COUNT; i++) {
            winCount.add(0);
        }
    }

    public List<Integer> getWincount() {
        return winCount;
    }
}
