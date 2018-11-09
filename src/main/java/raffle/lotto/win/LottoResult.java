package raffle.lotto.win;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoResult {

    private static final int SCALE= 2;

    private int lottoPrice;

    private List<WinLotto> winLottos;

    public LottoResult(List<WinLotto> winLottos, int lottoPrice) {
        this.winLottos = winLottos;
        this.lottoPrice = lottoPrice;
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
        int totalMoney = winLottos.stream().mapToInt(WinLotto::getPrice).sum();
        double profit = (double) totalMoney / money;
        return new BigDecimal(profit)
                .setScale(SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
