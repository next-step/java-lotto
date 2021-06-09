package lotto;

import java.math.BigDecimal;
import java.util.List;

import static lotto.Lotto.LOTTO_PRICE;

public class LottoStatistics {
    public static BuyingCount getLottoBuyingCount(Money money) {
        return new BuyingCount(money.value() / LOTTO_PRICE);
    }

    public static double calculateLottoTicketProfit(LottoTicket lottoTicket) {
        List<Lotto> lottoList = lottoTicket.lottoList();
        int totalProfit = 0;
        for (int i = 0; i < lottoList.size(); i++) {
            totalProfit += lottoList.get(i).lottoWin().winPrice();
        }
        BigDecimal divisor = new BigDecimal(lottoList.size() * LOTTO_PRICE);
        BigDecimal totalProfitRatio = new BigDecimal(totalProfit).divide(divisor, 2, BigDecimal.ROUND_HALF_DOWN);
        return totalProfitRatio.doubleValue();
    }

    public static int countLottoWinNumMatch(List<Lotto> lottoList, LottoWin lottoWin) {
        int count = 0;
        for (Lotto lotto : lottoList) {
            count += getLottoWinNumMatchValue(lotto, lottoWin);
        }
        return count;
    }

    private static int getLottoWinNumMatchValue(Lotto lotto, LottoWin lottoWin) {
        if (isLottoWinNumMatch(lotto, lottoWin)) {
            return 1;
        }
        return 0;
    }

    private static boolean isLottoWinNumMatch(Lotto lotto, LottoWin lottoWin) {
        return lottoWin == lotto.lottoWin();
    }
}
