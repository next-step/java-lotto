package lotto;

import lotto.data.Lottos;

public class VendingMachine {
    private Wallet wallet;

    public VendingMachine(int budget) {
        this.wallet = new Wallet(budget);
    }

    public Lottos buy() {
        return new Lottos(wallet);
    }

    public int getExpend() {
        return wallet.getExpend();
    }
}
