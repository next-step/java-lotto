package lotto.domain;

import lotto.util.NumberUtil;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private LottoBucket lottoBucket;

    public LottoMachine(){
        lottoBucket = new LottoBucket();
    }

    public LottoBucket buyLotto(String money) {
        long calcuratableMoney = NumberUtil.stringToLong(money);
        long numberOfLotto = calcuratableMoney / LOTTO_PRICE;
        LottoBucket lottos = createLottos(numberOfLotto);
        return lottos;
    }

    protected LottoBucket createLottos(long numberOfLotto) {
        for(int i = 0; i < numberOfLotto; i++){
            lottoBucket.createLotto(new Lotto());
        }
        return this.lottoBucket;
    }

    public LottoBucket getLottoBuckets() {
        return this.lottoBucket;
    }

}
