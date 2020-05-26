package com.lotto;

import com.lotto.controller.LottoGame;
import com.lotto.domain.ShuffleLottoExtractor;

public class LottoMain {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new ShuffleLottoExtractor());
        lottoGame.playLottoGame();
    }
}
