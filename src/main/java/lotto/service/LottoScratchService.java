package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.AnnounceWinning;

import java.util.List;
import java.util.stream.Collectors;

public class LottoScratchService {

    public List<LottoRank> scratch(Lottos lottos, AnnounceWinning announceWinning) {
        return lottos.getLottos().stream()
                .map(lotto -> calculateMatchCount(lotto, announceWinning))
                .map(LottoRank::of)
                .collect(Collectors.toList());
    }

    private int calculateMatchCount(Lotto lotto, AnnounceWinning announceWinning) {
        return (int) announceWinning.getWinning().stream()
                .filter(num -> lotto.getLotto().contains(num))
                .count();
    }
}
