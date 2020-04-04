package lotto.Domain;


import java.util.ArrayList;

public class Buyer {

    int amount;
    LottoMachine lottoMachine;

    private Buyer(int amount) {
        this.amount = amount;
        lottoMachine = LottoMachine.init();
    }

    public static Buyer of(int amount) {
        return new Buyer(amount);
    }

    public Lottos autoLotto() {
        Lottos lottos = Lottos.init(new ArrayList<>());
        int LottoCount = lottoMachine.boughtLottoCount(amount);
        for (int i = 0; i < LottoCount; i++) {
            Lotto lotto = lottoMachine.buyLotto(lottoMachine.makeAutoTargetNumber());
            lottos.add(lotto);
        }

        return lottos;
    }
}
