package step3.model;

import java.util.HashMap;
import java.util.Map;

import static step3.enumeration.LottoRank.ALL_LOTTO_RANK;

public class WinnerBoard {

    public Map<String, Integer> winnerBoard;

    public WinnerBoard() {
        this.winnerBoard = new HashMap<>();
        ALL_LOTTO_RANK.forEach(rank -> winnerBoard.put(rank.name(), 0));
    }
}
