package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AutoLotto implements LottoStrategy {
    private AutoLotto() {
    }

    private static AutoLotto INSTANCE = null;

    public static AutoLotto getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AutoLotto();
        }
        return INSTANCE;
    }

    @Override
    public Lotto getLotto(List<LottoNum> allList, int count) {
        List<LottoNum> copyList = new ArrayList<>(allList);
        Collections.shuffle(copyList, new Random());
        List<LottoNum> lottoNumbers = copyList.subList(0, count);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
