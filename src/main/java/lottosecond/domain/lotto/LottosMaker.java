package lottosecond.domain.lotto;

import lottosecond.domain.LottoBuyMoney;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottosMaker {

    public static Lottos makeLottoList(CustomShuffle shuffle, LottoBuyMoney lottoBuyMoney) {
        int lottoCount = lottoBuyMoney.countLotto();

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(new HashSet<>(shuffle.makeShuffle())));
        }

        return new Lottos(lottoList);
    }
}
