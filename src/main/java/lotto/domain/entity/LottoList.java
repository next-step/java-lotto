package lotto.domain.entity;

import lotto.domain.Lotto;
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

    public Rank compareWith(Lotto winningLotto){
        Rank rank = new Rank();
        for (Lotto buyLotto : lottoList) {
            checkRank(buyLotto.confirmWinning(winningLotto), rank);
        }
        return rank;
    }

    private void checkRank(int count, Rank rank) {
        if (count == 3) {
            rank.addFourth();
        }
        if (count == 4) {
            rank.addThird();
        }
        if (count == 5) {
            rank.addSecond();
        }
        if (count == 6) {
            rank.addFirst();
        }
    }

    @Override
    public String toString() {
        return "LottoList = " + lottoList;
    }
}
