package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.winning.WinningStat;
import lotto.dto.LottoNumbersDto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int unitCount, LottoStrategy lottoStrategy) {
        final List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < unitCount; i++) {
            lottoList.add(new Lotto(lottoStrategy));
        }

        this.lottos = lottoList;
    }

    public WinningStat rating(Lotto winningLotto, LottoNumber bonusBall) {
        final WinningStat winningStat = new WinningStat();

        for (Lotto lotto : this.lottos) {
            winningStat.judgeWinning(winningLotto, lotto, bonusBall);
        }

        return winningStat;
    }

    public LottoNumbersDto lottoNumbersDto() {
        final LottoNumbersDto lottoNumbersDto = new LottoNumbersDto();

        for (Lotto lotto : this.lottos) {
            lottoNumbersDto.setLottoNumber(lotto.getIntegerLottoNumbers());
        }

        return lottoNumbersDto;
    }
}
