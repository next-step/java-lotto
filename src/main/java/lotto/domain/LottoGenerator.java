package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public Lottos generateLottos(Fee fee) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < fee.convertToGameUnit(); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        List<Integer> lottoGame = rangeOfLotto();
        Collections.shuffle(lottoGame);
        lottoGame = lottoGame.subList(0,6);
        Collections.sort(lottoGame);
        return new Lotto(lottoGame);
    }

    private static List<Integer> rangeOfLotto() {
        List<Integer> lottoGame = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoGame.add(i);
        }
        return lottoGame;
    }
}
