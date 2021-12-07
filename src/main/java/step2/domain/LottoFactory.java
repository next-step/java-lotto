package step2.domain;

import step2.exception.LottoException;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final int LOTTO_PRICE = 1000;

    private LottoFactory() {
    }

    public static Lotto buyWithMoney(String moneyString) {
        int money = toInt(moneyString);
        return buyWithMoney(money);
    }

    private static int toInt(String moneyString) {
        try{
            return Integer.parseInt(moneyString);
        }
        catch(NumberFormatException e){
            throw new LottoException("구입할 로또 가격을 숫자로 입력해야합니다.");
        }

    }


    public static Lotto buyWithMoney(int money) {
        int numberOfLottoNumbers = money / LOTTO_PRICE;

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < numberOfLottoNumbers; i++) {
            LottoNumbers lottoNumbers = LottoNumbers.generate();
            lottoNumbersList.add(lottoNumbers);
        }

        return new Lotto(new LottoWinningRules(), lottoNumbersList, numberOfLottoNumbers * LOTTO_PRICE);
    }

}
