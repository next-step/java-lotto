package step2.domain;

import step2.exception.LottoException;

import java.util.ArrayList;
import java.util.List;

public class LottosFactory {

    private LottosFactory() {
    }

    public static Lottos buyWithMoney(String moneyString) {
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

    public static Lottos buyWithMoney(int money) {
        int numberOfLotto = money / LottoFactory.getLottoPrice();
        List<Lotto> lottoList = generateLotto(numberOfLotto);
        return new Lottos(new LottoWinningRules(), lottoList, numberOfLotto * LottoFactory.getLottoPrice());
    }

    private static List<Lotto> generateLotto(int numberOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = LottoFactory.generate();
            lottoList.add(lotto);
        }
        return lottoList;
    }

}
