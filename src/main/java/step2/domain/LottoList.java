package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public LottoList(Integer purchaseAmount) {
        int purchaseCount = purchaseAmount/1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        this.lottoList = lottoList;
    }

    public List<Integer> checkMatching(List<Integer> winningNumbers) {
        List<Integer> matchingList = new ArrayList<>();
        lottoList.stream().forEach(i -> matchingList.add(i.checkMatching(winningNumbers)));
        return matchingList;
    }

    public List<Integer> getCountList(List<Integer> matchingList) {
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < Lotto.SIZE+1;i++) {
            countList.add(Collections.frequency(matchingList,i));
        }
        return countList;
    }
}
