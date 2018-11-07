package raffle.lotto.win;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static raffle.lotto.LottoMachine.LOTTO_PRICE;

public class LottoResult {

    private static final int SCALE= 2;

    private List<WinLotto> winLottos;

    public LottoResult(List<WinLotto> winLottos) {
        this.winLottos = winLottos;
    }

    public int getLottoCount(WinLotto selectWinLotto) {
        return (int) winLottos.stream()
                .filter(winLotto -> winLotto.equals(selectWinLotto))
                .count();
    }

    public List<WinLotto> getWinLottos() {
        return winLottos;
    }

    public double  getResultProfit() {
        return calculateProfit(winLottos.size() * LOTTO_PRICE);
    }

    public double calculateProfit(int money) {
        int totalMoney = winLottos.stream().mapToInt(WinLotto::getPrice).sum();
        double profit = (double) totalMoney / money;
        return new BigDecimal(profit)
                .setScale(SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
