package study.lotto.controller;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoBundle;

import java.util.ArrayList;
import java.util.List;

public class LottoBundleMaker {

    public static LottoBundle createLottoBundle(List<Lotto> lottoList) {
        return new LottoBundle(lottoList);
    }

    // 특정 금액으로 n개의 lotto 생성
    public static List<Lotto> createLottoList(Integer money) {
        int trial = money / 1000;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < trial; i++) {
            Lotto lotto = Lotto.autoGenerate();
            lottos.add(lotto);
        }
        return lottos;
    }
}
