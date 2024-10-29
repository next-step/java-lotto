package lotto.lotto;

public class LottoMachine {

    private final static int MIN_PRICE = 1000;

    private final int price;
    private final int manualCnt;
    private final int autoCnt;

    public LottoMachine(final int price, final int manualCnt) {
        this.price = price;
        this.manualCnt = manualCnt;
        this.autoCnt = calculateAutoCnt();
        validatePrice(price);
    }

    public Lottos createLottos(LottoGeneratorStrategy lottoGeneratorStrategy, LottoParameters lottoParameters) {
        return lottoGeneratorStrategy.generateLotto(lottoParameters);
    }

    public int getAutoCnt() {
        return autoCnt;
    }

    public int getManualCnt() {
        return manualCnt;
    }

    public int calculateAutoCnt() {
        int autoCnt = price / MIN_PRICE - manualCnt;
        if (autoCnt < 0) {
            throw new IllegalArgumentException("금액을 초과하였습니다.");
        }
        return autoCnt;
    }

    private void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("1000원 이상입니다.");
        }
    }

}
