package lotto.domain;

import lotto.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private BigDecimal inputMoney = BigDecimal.ZERO;
    private LottoBucket lottoBucket;

    public LottoMachine() {
        lottoBucket = new LottoBucket();
    }

    protected LottoBucket createLottos(long numberOfLotto) {
        for(int i = 0; i < numberOfLotto; i++){
            lottoBucket.createLotto(new Lotto());
            lottoBucket.increaseAutoLottoCount();
        }
        return this.lottoBucket;
    }

    public LottoBucket getLottoBuckets() {
        return this.lottoBucket;
    }

    public BigDecimal inputMoney(String money) {
        long longMoney = NumberUtil.stringToLong(money);
        this.inputMoney = BigDecimal.valueOf(longMoney);
        return this.inputMoney;
    }

    public LottoBucket buyAutoLotto() {
        BigDecimal divide = this.inputMoney.divide(BigDecimal.valueOf(LOTTO_PRICE), RoundingMode.FLOOR);
        LottoBucket lottos = createLottos(NumberUtil.convertBigDecimalToLong(divide));
        return lottos;
    }

    public Lotto buyManualLotto(String lottoNumbers) {
        int insufficientCash = -1;
        Set<LottoNumber> lottoNumberSet = NumberUtil.convertStringLottoNumbers(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumberSet);
        lottoBucket.addLotto(lotto);
        int compareInputMoney = inputMoney.compareTo(BigDecimal.valueOf(1000));
        if(compareInputMoney == insufficientCash){
            throw new ArithmeticException("구매할 잔액이 부족합니다.");
        }
        inputMoney = inputMoney.subtract( BigDecimal.valueOf(1000));
        lottoBucket.increaseManualLottoCount();
        return lotto;
    }
}
