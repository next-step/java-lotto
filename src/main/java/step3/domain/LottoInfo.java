package step3.domain;

public class LottoInfo {
    private static final int CARGE_OF_LOTTO = 1000;
    private int charge;
    private int count;

    public LottoInfo(int charge) {
        calculateNumOfLotto(charge);
        this.charge = charge;
    }

    private void calculateNumOfLotto(int charge) {
        this.count = charge/CARGE_OF_LOTTO;
    }

    public int getCharge() {
        return charge;
    }

    public int getCount() {
        return count;
    }
}
