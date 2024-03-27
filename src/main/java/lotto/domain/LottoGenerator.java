package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {

    private LottoGenerator() {
    }

    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 45;

    public static Lottos generateLottos(Fee fee) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < fee.convertToGameUnit(); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static Lotto generateLotto() {
        List<Integer> lottoGame = rangeOfLotto();
        Collections.shuffle(lottoGame);
        lottoGame = lottoGame.subList(0,6);
        Collections.sort(lottoGame);
        return new Lotto(lottoGame);
    }

    private static List<Integer> rangeOfLotto() {
        List<Integer> lottoGame = new ArrayList<>();
        for (int i = START_NUMBER; i <= LAST_NUMBER; i++) {
            lottoGame.add(i);
        }
        return lottoGame;
    }
}
