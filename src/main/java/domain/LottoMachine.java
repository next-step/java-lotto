package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int GAME_AMOUNT = 1000;

    public List<Lotto> purchaseLotto(int amount) {
        List<Lotto> lottoGames = new ArrayList<>();
        for (int i = 0; i < games(amount); i++) {
            lottoGames.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }

        return lottoGames;
    }

    private int games(int amount) {
        return amount / GAME_AMOUNT;
    }
}
