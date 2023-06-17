package lotto.auto.domain;

import lotto.auto.vo.Money;
import lotto.auto.vo.WinNumber;

import java.util.List;

public class LottoHandler {

    private final int LOTTO_PRICE = 1000;

    public int countLotto(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    public void addAutoLottoByCount(LottoPaper lottoPaper, int count) {
        lottoPaper.addAutoLottos(count);
    }

    public List<Win> confirmWinner(LottoPaper lottoPaper, WinNumber winNumbers) {
        return lottoPaper.checkWins(winNumbers);
    }

    public Double getReturn(Money money, List<Win> wins) {
        int winMoney = 0;
        for (Win win : wins) {
            winMoney += (win.getReward());
        }
        return (double) ((double) winMoney / (double) money.getMoney());
    }

}
