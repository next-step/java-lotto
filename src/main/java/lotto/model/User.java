package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {

    private final int count;
    private final List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Rank, Integer> getRanks() {
        return Statistics.getRanks();
    }

    public void setRanks(WinningNumber winningNumber) {
        Statistics.setRanks(winningNumber, lottos);
    }

    public int getCount() {
        return count;
    }

}
