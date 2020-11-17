package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.Winning;

import java.util.List;
import java.util.stream.Collectors;

public class LottoScratchService {

    public List<LottoRank> scratch(Lottos lottos, Winning winning) {
        return lottos.getLottos().stream()
                .map(lotto -> calculateMatchCount(lotto, winning))
                .map(LottoRank::of)
                .collect(Collectors.toList());
    }

    public int calculateMatchCount(Lotto lotto, Winning winning) {
        return (int) winning.getWinning().stream()
                .filter(num -> lotto.getLotto().contains(num))
                .count();
    }
}
