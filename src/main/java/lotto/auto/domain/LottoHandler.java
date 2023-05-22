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
    public List<Lotto> createLotto(int count) {
        List<Lotto> lottos = new ArrayList<>(count);
        for(int i = 0; i < count; i ++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public List<Win> confirmWinner(List<Lotto> lottos, WinNumber winNumbers) {
        List<Win> wins = new ArrayList<>();
        for (Lotto lotto : lottos) {
            wins.add(lotto.checkWin(winNumbers));
        }
        return wins;
    }

    public Double getReturn(Money money, List<Win> wins) {
        int winMoney = 0;
        for (Win win : wins) {
            winMoney += (win.getReward());
        }
        return (double) ((double) winMoney / (double) money.getMoney());
    }

}
