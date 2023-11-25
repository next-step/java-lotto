public class LottoStore {
    private static final int LOTTOPRICE = 1000;
    public Lottos sell(int amount) {
        int lottoCount = this.calculateLottoCount(amount);
        return LottoMachine.make(lottoCount);
    }

    private int calculateLottoCount(int amount) {
        return amount / LOTTOPRICE;
    }

}
