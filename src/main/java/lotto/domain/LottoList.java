package lotto.domain;

import lotto.domain.rating.WinningRatingType;
import lotto.domain.strategy.LottoStrategy;
import lotto.dto.WinningStatDto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(int unitCount, LottoStrategy lottoStrategy) {
        final List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < unitCount; i++) {
            lottoList.add(new Lotto(lottoStrategy));
        }

        this.lottoList = lottoList;
    }

    public WinningStatDto rating(Lotto winningLotto) {
        final WinningStatDto winningStatDto = new WinningStatDto(0, 0, 0, 0);

        for (Lotto lotto : this.lottoList) {
            final WinningRatingType type = WinningRatingType.findBy(lotto.statCount(winningLotto));
            winningStatDto.includeStatCount(type);
        }

        return winningStatDto;
    }
}
