package step2.controller;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private LottoMachine() {}

    public static int calculateLottoCount(int inputMoney) {
        return inputMoney / LOTTO_PRICE;
    }
}
