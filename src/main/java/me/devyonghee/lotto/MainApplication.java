package me.devyonghee.lotto;

import me.devyonghee.lotto.controller.LottoGame;

public final class MainApplication {

    public static void main(String[] args) {
        LottoGame.of(System.in, System.out).start();
    }
}
