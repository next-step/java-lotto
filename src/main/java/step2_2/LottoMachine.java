package step2_2;

public class LottoMachine {

    private LottoMachine() {
    }

    public static LottoBundle purchaseLottos(Money money) {
        return new LottoBundle(money);
    }
}
