package lotto;

public class LottoBuy {
    private static final String LOTTO_BUY_RESULT_OUTPUT = "%d개를 구매하셨습니다.\n";

    private Lottos lottos;
    private int buyCount;

    public Lottos buyLotto(Pay payForLotto) {
        this.buyCount = payForLotto.countBuyLotto(LottoValidationUtils.LOTTO_COST);
        lottos = new Lottos();
        for (int count = 0; count < buyCount; count++) {
            lottos.createRandomLotto();
        }
        printBuyInfo();
        return lottos;
    }

    public Lottos buyOneRandomLotto(LottoRandomNumber lottoRandomNumber) {
        return new Lottos(new Lotto(lottoRandomNumber));
    }

    private void printBuyInfo() {
        System.out.printf(LOTTO_BUY_RESULT_OUTPUT, buyCount);
    }
}
