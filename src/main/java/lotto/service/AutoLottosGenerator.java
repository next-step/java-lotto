package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottosGenerator implements LottoGenerator {

    private final int count;

    public AutoLottosGenerator(int count) {
        this.count = count;
    }

    @Override
    public Lottos generate() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(generateAutoLotto());
        }
        return new Lottos(lottoList);
    }

    private Lotto generateAutoLotto() {
        List<Integer> list = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return new Lotto(list.subList(0, Lotto.LOTTO_COUNT));
    }
}
