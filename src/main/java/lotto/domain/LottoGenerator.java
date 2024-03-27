package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {

    private LottoGenerator() {
    }

    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 45;
    private static final List<Integer> lottoGame = createLottoGame();

    private static List<Integer> createLottoGame() {
        List<Integer> lottoGame = new ArrayList<>();
        for (int i = START_NUMBER; i <= LAST_NUMBER; i++) {
            lottoGame.add(i);
        }
        return lottoGame;
    }

    public static Lottos generateLottos(Fee fee) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < fee.convertToGameUnit(); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static Lotto generateLotto() {
        List<Integer> clonedLottoGame = new ArrayList<>(lottoGame);
        Collections.shuffle(clonedLottoGame);
        clonedLottoGame = clonedLottoGame.subList(0,6);
        Collections.sort(clonedLottoGame);
        return new Lotto(clonedLottoGame);
    }
}
