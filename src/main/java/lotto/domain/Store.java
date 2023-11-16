package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static final int LOTTO_PRICE = 1000;

    public static int sellableLottoCount(int value) {
        return value/LOTTO_PRICE;
    }

    public static List<Lotto> autoGamesSelling(int value) {
        List<Lotto> lottoGames = new ArrayList<>();
        for (int game = 0; game < sellableLottoCount(value); game++) {
            Lotto lottoGame = new Lotto();
            lottoGames.add(lottoGame);
            System.out.println(lottoGame);
        }
        return lottoGames;
    }
}
