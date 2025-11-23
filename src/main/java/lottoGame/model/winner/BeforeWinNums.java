package lottoGame.model.winner;

import java.util.Collections;
import java.util.List;

public class BeforeWinNums {
    private final List<Integer> winNums;

    public BeforeWinNums(List<Integer> winNums) {
        this.winNums = winNums;
    }

    public boolean isContain(int num) {
        return winNums.contains(num);
    }
}
