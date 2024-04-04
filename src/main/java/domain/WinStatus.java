package domain;

import java.util.ArrayList;
import java.util.List;

public class WinStatus {
    private static List<Integer> winCount;;
    private final int VALID_WIN_COUNT = 5;
    private final int WINCOUNT = 3;

    public void correct(int count) {
        if (count >= WINCOUNT) {
            int index = count - WINCOUNT;
            winCount.set(index, winCount.get(index) + 1);
        }
    }

    public WinStatus() {
        winCount = new ArrayList<>();
        for (int i = 0; i < VALID_WIN_COUNT; i++) {
            winCount.add(0);
        }
    }

    public List<Integer> getWincount() {
        return winCount;
    }
}
