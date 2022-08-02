package lotto.interfaces;

import lotto.domain.Rank;

import java.util.Map;

public interface LotteryResult {
    Map<Rank, Integer> result();

    double profit(Map<Rank, Integer> results, int spent);
}
