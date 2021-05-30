package lotto.domain.entity;

import lotto.domain.Lotto;
import lotto.domain.RankCounter;
import lotto.domain.generator.AutomaticLottoNumbersGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LottoList {

    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            lottoList.add(new Lotto(new AutomaticLottoNumbersGenerator()));
        }
    }

    public LottoList(Lotto... lottoArrays) {
        lottoList.addAll(Arrays.asList(lottoArrays));
    }

    public int size() {
        return lottoList.size();
    }

    public Lotto get(int index) {
        return lottoList.get(index);
    }

    public RankCounter compareWith(Lotto winningLotto, Number bonusNumber) {
        RankCounter rankCounter = new RankCounter();
        boolean matchBonus = false;
        for (Lotto purchased : lottoList) {
            matchBonus = isMatchBonus(purchased, bonusNumber);
            checkRank(purchased.confirmWinning(winningLotto), rankCounter, matchBonus);
        }
        return rankCounter;
    }

    private boolean isMatchBonus(Lotto purchased, Number bonusNumber) {
        return purchased.isNumber(bonusNumber);
    }

    private void checkRank(int count, RankCounter rankCounter, boolean matchBonus) {
        if (count == 3) {
            rankCounter.addCount(Rank.FIFTH);
        }
        if (count == 4) {
            rankCounter.addCount(Rank.FOURTH);
        }
        if (count == 5 && !matchBonus) {
            rankCounter.addCount(Rank.THIRD);
        }
        if (count == 5 && matchBonus) {
            rankCounter.addCount(Rank.SECOND);
        }
        if (count == 6) {
            rankCounter.addCount(Rank.FIRST);
        }
    }

    @Override
    public String toString() {
        return "LottoList = " + lottoList;
    }
}
