package domain;

import java.util.ArrayList;
import java.util.List;

public class WinPrizes {

    List<Prize> winPrize = new ArrayList<>();

    public void winPrize(Prize prize) {
        winPrize.add(prize);
    }

    public List<Prize> getWinPrize() {
        return winPrize;
    }

}
