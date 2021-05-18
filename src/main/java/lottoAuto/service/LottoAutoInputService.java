package lottoAuto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoInputService {

    private LottoRandom lottoRandom = new LottoRandom();

    private List<Integer> winningNumber = new ArrayList<>();
    private static final int lotto_price = 1000;

    public int inputPrice(int price) {
        int amount = price / lotto_price;

        return amount;
    }

    public List<Lotto> inputUserLottoNumber(int amount) {
        List<Lotto> userLotto = lottoRandom.setLotto(amount);
        return userLotto;
    }

    public Lotto inputWinningNumber(String winningNumber_string) {
        String[] splitString = winningNumber_string.split(",");

        for (int i = 0; i < splitString.length; i++) {
            winningNumber.add(Integer.valueOf(splitString[i]));
        }
        Lotto winningLotto = new Lotto(winningNumber);
        return winningLotto;

    }
}
