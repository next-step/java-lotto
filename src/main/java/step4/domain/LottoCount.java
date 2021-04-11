package step4.domain;


import step4.exception.IllegalLottoCountException;

public class LottoCount {
    public static final int LOTTO_PRICE = 1_000;

    private final long lottoPurchaseAmount;
    private final int countOfUserLotto;

    public LottoCount(long lottoPurchaseAmount, int countOfUserLotto) {
        amountValidation(lottoPurchaseAmount, countOfUserLotto);

        this.lottoPurchaseAmount = lottoPurchaseAmount;
        this.countOfUserLotto = countOfUserLotto;
    }

    private void amountValidation(long lottoPurchaseAmount, int countOfUserLotto) {
        if ((lottoPurchaseAmount / LOTTO_PRICE) < countOfUserLotto){
            throw new IllegalLottoCountException("수동으로 구매할 번호의 갯수가 총 갯수를 넘을 수 없습니다.");
        }
    }

    public int getLottoCount() {
        return getCalculatedLottoCount() - countOfUserLotto;
    }

    private int getCalculatedLottoCount() {
        return (int) Math.floor(lottoPurchaseAmount / LOTTO_PRICE);
    }

    public int getCountOfUserLottoNumber() {
        return countOfUserLotto;
    }

    public long getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }
}
