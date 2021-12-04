package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final int LOTTO_PRICE = 1000;

    private LottoFactory() {}

    public static Lotto buyWithMoney(String moneyString){
        int money = Integer.parseInt(moneyString);
        return buyWithMoney(money);
    }

    public static Lotto buyWithMoney(int money) {
        int numberOfLottoNumbers = money / LOTTO_PRICE;

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for(int i=0 ; i<numberOfLottoNumbers;i++){
            LottoNumbers lottoNumbers = LottoNumbers.generate();
            lottoNumbersList.add(lottoNumbers);

        }
        return new Lotto(new LottoWinningRules(), lottoNumbersList, numberOfLottoNumbers * LOTTO_PRICE);
    }

}
