package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    public static void outputLottoNumbers(int price) {
        int lottoAmount = price / 1000;

        System.out.printf("%s개를 구매했습니다.\n", lottoAmount);
        System.out.println(new Lottos(lottoAmount));
    }
}
