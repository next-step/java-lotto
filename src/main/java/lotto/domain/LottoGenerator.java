package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public Lotto<List> generateLottos(Fee fee) {

        return null;
    }

    public List<Integer> generateLotto() {
        List<Integer> lottoGame = rangeOfLotto();
        return lottoGame;
    }

    private static List<Integer> rangeOfLotto() {
        List<Integer> lottoGame = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoGame.add(i);
        }
        System.out.println(lottoGame);
        Collections.shuffle(lottoGame);
        System.out.println("shuffle->" + lottoGame);
        lottoGame = lottoGame.subList(0,6);
        System.out.println("cut->" + lottoGame);
        Collections.sort(lottoGame);
        System.out.println("sort->" + lottoGame);
        return lottoGame;
    }
}
