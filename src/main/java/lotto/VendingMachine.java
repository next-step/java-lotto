package lotto;

import java.util.List;

import lotto.data.Lottos;

public class VendingMachine {
    private Wallet wallet;
    private List<Lotto> manualNumbers;

    public VendingMachine(Wallet wallet, List<Lotto> manualNumbers) {
        this.wallet = wallet;
        this.manualNumbers = manualNumbers;
    }

    public Lottos buy() {
        return new Lottos(wallet, manualNumbers);
    }

    public int getExpend() {
        return wallet.getExpend();
    }
}
