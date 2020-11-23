package lotto.domain;

import lotto.common.Lotto;
import lotto.dto.LottoGameResultDto;

import java.util.List;

public class LottoGameResult {

    private final List<Rank> value;

    public LottoGameResult(List<Rank> value) {
        this.value = value;
    }

    public LottoGameResultDto getRankCount(Rank rank) {
        long matchingCount = value.stream()
                .filter(ranks -> ranks.equals(rank))
                .count();

        return new LottoGameResultDto(rank, matchingCount);


    }
}
