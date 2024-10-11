package step3.model;

import java.util.HashSet;
import java.util.Set;

public class LottoMachine {

    private final static String MINIMUM_LOTTO_NUM_MESSAGE = "로또는 최소 1장이상부터 생성이 가능합니다.";
    private final static String MINIMUM_LOTTO_PRICE_MESSAGE = "로또의 가격은 1000원입니다.";

    private static final int LOTTO_PRICE = 1000; //로또 가격
    private static final int LOTTO_NUMBER = 6; //로또 번호 수

    //로또 구매
    public PurchasedLotto buyLotto(int money, ManualLotto manualLotto) {
        PurchasedLotto purchasedLotto = new PurchasedLotto();
        getManualLotto(purchasedLotto, manualLotto);
        getAutoLotto(purchasedLotto, receiveMoney(money - manualLottoMoney(manualLotto)));
        return purchasedLotto;
    }

    //로또 장수 가져오기
    public int receiveMoney(int money) {
        confirmMoneyMinimum(money);
        return money / LOTTO_PRICE;
    }

    //수동으로 구매한 금액 가져오기
    public int manualLottoMoney(ManualLotto manualLotto) {
        return manualLotto.getLottoList().size() * LOTTO_PRICE;
    }

    //로또 자동 구매
    public void getAutoLotto(PurchasedLotto purchasedLotto, int num) {
        checkNumMinus(num);
        for (int i = 0; i < num; i++) {
            purchasedLotto.addLotto(outPutAutoLotto());
        }
    }

    //수동 로또 구매
    public void getManualLotto(PurchasedLotto purchasedLotto, ManualLotto manualLotto) {
        purchasedLotto.addManualLotto(manualLotto);
    }

    //로또 자동 1장 가져오기
    public Lotto outPutAutoLotto() {
        Set<LottoNumber> lotto = new HashSet<>();

        while (lotto.size() < LOTTO_NUMBER) {
            lotto.add(new LottoNumber());  // 중복된 값은 자동으로 제외
        }

        return new Lotto(lotto);
    }

    //1이하 번호가 있을 시 예외발생
    private void checkNumMinus(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_NUM_MESSAGE);
        }
    }

    //돈이 1000원 미만이면 로또구매 X 예외발생
    private void confirmMoneyMinimum(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_PRICE_MESSAGE);
        }
    }

}
