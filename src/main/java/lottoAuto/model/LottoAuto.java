package lottoAuto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoAuto {
    private LottoRandom lottoRandom = new LottoRandom();
    private List<Integer> winningNumber = new ArrayList<>();

    public Lottos inputUserLottoNumber(int amount) {
        Lottos userLottos = lottoRandom.setLotto(amount);
        return userLottos;
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
