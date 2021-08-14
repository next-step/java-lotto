package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final LottoGame lottoGame;

    public Lotto(final int price) {
        lottoGame = new LottoGame(price);
    }

    public int getGameNum(){
        return lottoGame.getTicketNum();
    }
}
