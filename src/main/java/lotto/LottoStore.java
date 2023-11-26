package lotto;

public class LottoStore {
    private static final int LOTTOPRICE = 1000;
    private final int amount;


    public LottoStore(int amount) {
        this.amount = amount;
    }

    public Lottos sell() {
        int lottoCount = this.calculateLottoCount(amount);

        Lottos lottos = LottoMachine.make(lottoCount);
        Lotto lotto = LottoMachine.resultIs();
        LottoResult match = LottoMachine.match(lotto, lottos);
        return LottoMachine.make(lottoCount);
    }

    private int calculateLottoCount(int amount) {
        return amount / LOTTOPRICE;
    }

}
