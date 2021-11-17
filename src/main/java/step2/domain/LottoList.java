package step2.domain;

import step2.domain.starategy.GetLottoNumberStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(Integer purchaseAmount, GetLottoNumberStrategy getLottoNumberStrategy) {
        int purchaseCount = purchaseAmount/1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(getLottoNumberStrategy);
            lottoList.add(lotto);
        }
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    /***
     *  matchingList 는
     *  [ 0개 맞춘 로또 수, 1개 맞춘 로또 수, ... ] 을 의미한다.
     */
    public List<Integer> checkMatching(List<Integer> winningNumbers) {
        List<Integer> matchingList = new ArrayList<>();
        for (int i = 0; i < Lotto.SIZE+1; i++) {
            matchingList.add(0);
        }
        lottoList.stream().forEach(i -> matchingList.set(i.checkMatching(winningNumbers),matchingList.get(i.checkMatching(winningNumbers))+1));
        return matchingList;
    }
}
