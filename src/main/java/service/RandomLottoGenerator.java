package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Lotto;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto createRandomLotto() {
        List<Integer> lottoNumRange = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNumRange.add(i);
        }
        Collections.shuffle(lottoNumRange);
        List<Integer> pickedNumbers = lottoNumRange.subList(0, 6);
        Collections.sort(pickedNumbers);
        return Lotto.from(pickedNumbers);

    }
}
