package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPaper;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    public static void printLottoNumber(LottoPaper lottoPaper) {
        List<Lotto> lottos = lottoPaper.getLottoPapers();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumber());
        }
    }

    public static void printInsights(LottoPaper lottoPaper) {
        List<Lotto> lottos = lottoPaper.getLottoPapers();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getHitCount());
        }
    }

}
