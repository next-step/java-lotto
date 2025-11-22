package lottoGame.controller;

import lottoGame.model.lotto.LottoMachine;

public class LottoStore {
    public static final int PER_LOTTO_PRICE = 1000;

    public void start() {
        LottoMachine lottoMachine = new LottoMachine();
    }


    public static void main(String[] args) {
        new LottoStore().start();
    }
}
