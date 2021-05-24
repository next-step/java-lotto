package lotto;

public class LottoBuy {
    private static final int LOTTO_COST = 1000;
    private static final String LOTTO_BUY_RESULT_OUTPUT = "%d개를 구매하셨습니다.";

    private Lottos lottos;
    private int buyCount;

    public Lottos buyLotto(int buyPay) {
        this.buyCount = buyPay / LOTTO_COST;
        if (buyPay < LOTTO_COST) {
            throw new IllegalArgumentException("구매금액은 1000원 이상입니다.");
        }
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
        System.out.println();
        System.out.println(lottos.toString());
    }
}
