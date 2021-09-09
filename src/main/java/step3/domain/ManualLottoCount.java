package step3.domain;

public class ManualLottoCount {
    private static final String MANUAL_LOTTO_NUM_ERROR = "수동으로 구매할 수 있는 로또의 수는 구입하는 로또의 수 보다 적어야합니다.";

    private final int numOfManualPurchaseLotto;

    public ManualLottoCount(int numOfManualPurchaseLotto, int totalNumOfLotto) {
        validInputConfirm(numOfManualPurchaseLotto, totalNumOfLotto);
        this.numOfManualPurchaseLotto = numOfManualPurchaseLotto;
    }

    private void validInputConfirm(int numOfManualPurchaseLotto, int totalNumOfLotto) {
        if (numOfManualPurchaseLotto > totalNumOfLotto) {
            throw new IllegalArgumentException(MANUAL_LOTTO_NUM_ERROR);
        }
    }

    public int getNumOfManualPurchaseLotto() {
        return numOfManualPurchaseLotto;
    }

}
