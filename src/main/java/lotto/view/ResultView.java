package lotto.view;

import lotto.domain.*;

import java.util.List;

public class ResultView {
    public static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void printOfBuyLotto(LottoGame lottoGame, NumberStrategy numberStrategy) {
        System.out.println(lottoGame.countOfLotto() + BUY_LOTTO_MESSAGE);
        List<Lotto> lottos = lottoGame.createLotto(numberStrategy);
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }
    }
}
