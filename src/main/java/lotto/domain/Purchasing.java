package lotto.domain;

import lotto.strategy.RandomNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Purchasing {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList;

    public Purchasing(int money) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoList.add(new Lotto(new RandomNumberStrategy()));
        }
    }

    public List<Long> getMatchCntList(Lotto winningLotto) {
        return lottoList.stream()
                .map(lotto -> lotto.matchCnt(winningLotto))
                .collect(Collectors.toList());
    }

    public int getLottoCnt() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
