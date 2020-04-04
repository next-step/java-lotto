package study.lotto.controller;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoIssuer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoIssuer implements LottoIssuer {
    private List<Integer> lottoNumberList;

    public RandomLottoIssuer() {
        lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumberList.add(i);
        }
    }

    @Override public Lotto issue() {
        Collections.shuffle(lottoNumberList);
        return new Lotto(lottoNumberList.subList(0, 6));
    }
}
