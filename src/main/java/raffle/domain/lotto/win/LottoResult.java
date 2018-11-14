package raffle.domain.lotto.win;

import raffle.domain.lotto.money.Money;

import java.util.List;

public class LottoResult {

    private static final int SCALE= 2;

    private int lottoPrice;

    private List<WinLotto> winLottos;
    private Money moneyManament;

    public LottoResult(List<WinLotto> winLottos, int lottoPrice, Money money) {
        this.winLottos = winLottos;
        this.lottoPrice = lottoPrice;
        this.moneyManament = money;
    }

    public int getLottoCount(WinLotto selectWinLotto) {
        return (int) winLottos.stream()
                .filter(winLotto -> winLotto.equals(selectWinLotto))
                .count();
    }

    public double  getResultProfit() {
        return calculateProfit(winLottos.size() * lottoPrice);
    }

    public double calculateProfit(int money) {
        return moneyManament.getCalculateProfit(getSumPrice(money));
    }

    private double getSumPrice(int money) {
        return (double) winLottos.stream().mapToInt(WinLotto::getPrice).sum() / money;
    }
}
