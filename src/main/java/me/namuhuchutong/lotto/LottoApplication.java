package me.namuhuchutong.lotto;

public class LottoApplication {

    public static void main(String[] args){
        new LottoController(
                new InputView(),
                new OutputView(),
                new RandomNumberGenerator()).start();
    }
}
