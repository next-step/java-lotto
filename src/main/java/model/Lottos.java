package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> list;

    public Lottos(List<Lotto> lottos) {
        this.list = lottos;
    }

    public void checkWinner(List<Integer> winningNumbers, Placements placements) {

        for (Lotto lotto : list) {
            int matchingCount = lotto.getMatchNumber(winningNumbers);
            placements.insertPlacement();
        }

    }




}
