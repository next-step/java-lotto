package study.step2.view;

import java.util.List;

import study.step2.domain.Lotto;

public class ResultView {

    public static void showLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void showLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.lottoNumbers().lottoNumbers().toString()));
        System.out.println();
    }

}
