package lotto.service;

import lotto.domain.Dto.RankCountDto;
import lotto.domain.RanksCount;
import lotto.enums.WinningRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {
    public List<RankCountDto> createRanksCountDtos(RanksCount ranksCount) {
        List<RankCountDto> rankCountDtos = new ArrayList<>();

        for (Map.Entry<WinningRank, Integer> rank : ranksCount.entrySet()) {
            RankCountDto rankCountDto = new RankCountDto(rank.getKey(), rank.getValue());
            rankCountDtos.add(rankCountDto);
        }

        return rankCountDtos;
    }
}
