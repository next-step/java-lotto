package lotto.module;

import lotto.domain.Rank;

import java.util.Map;

public interface Game {
    public void generate();

    public Map<Rank, Integer> getStatistics();

    public double getYield();

    public Boolean isLoss();
}
