package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.*;

public class LottoGame {

    private final List<Lotto> value;

    public LottoGame(List<Lotto> value) {
        this.value = value;
    }

    public LottoResult getWinningResult(WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : value) {
            int numberOfEquals = winningNumbers.numberOfEquals(lotto);
            boolean matchBonus = winningNumbers.matchBonus(lotto);
            LottoRank rank = LottoRank.getLottoRank(numberOfEquals, matchBonus);
            int count = result.getOrDefault(rank, 0) + 1;
            result.put(rank, count);
        }
        return new LottoResult(result);
    }

    public List<Lotto> getValue(){
        return Collections.unmodifiableList(this.value);
    }

}
