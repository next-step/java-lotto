package lottoAuto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoAuto {
    private static final int LOTTO_PRICE = 1000;
    private static final String CHECK_LOTTO_PRICE_MESSAGE = "로또 1장의 가격은 1000원입니다.";

    private LottoRandom lottoRandom = new LottoRandom();

    public int calculateAmount(int price){
        checkLottoPrice(price);
        return price / LOTTO_PRICE;
    }

    private void checkLottoPrice(int price){
        if(price < LOTTO_PRICE){
            throw new IllegalArgumentException(CHECK_LOTTO_PRICE_MESSAGE);
        }
    }

    public UserLottos inputUserLottoNumber(int amount) {
        UserLottos userLottos = lottoRandom.setLotto(amount);

        return userLottos;
    }

    public WinningLotto inputWinningNumber(String winningLottoString,int bonusBall) {
        WinningLotto winningLotto = new WinningLotto(splitWinningNumber(winningLottoString),bonusBall);

        return winningLotto;
    }

    private List<Integer> splitWinningNumber(String winningLottoString){
        List<Integer> winningNumbers = new ArrayList<>();

        String[] splitedWinningNumbers = winningLottoString.split(",");
        for (int i = 0; i < splitedWinningNumbers.length; i++) {
            winningNumbers.add(Integer.valueOf(splitedWinningNumbers[i]));
        }
        return winningNumbers;
    }
}
