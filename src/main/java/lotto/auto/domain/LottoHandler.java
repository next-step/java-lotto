package lotto.auto.domain;

import lotto.auto.vo.Money;
import lotto.auto.vo.WinNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHandler {

    private final int LOTTO_PRICE = 1000;

    public int buyLotto(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
    public Lottos createLotto(int count) {
        return new Lottos(count);
    }

    public List<Win> confirmWinner(Lottos lottos, WinNumber winNumbers) {
        return lottos.checkWins(winNumbers);
    }

    public Double getReturn(Money money, List<Win> wins) {
        int winMoney = 0;
        for (Win win : wins) {
            winMoney += (win.getReward());
        }
        return (double) ((double) winMoney / (double) money.getMoney());
    }

}
