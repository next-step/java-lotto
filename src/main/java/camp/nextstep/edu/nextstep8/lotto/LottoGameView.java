package camp.nextstep.edu.nextstep8.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoGameView {

    public static void showLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottoNumbers().forEach(
                lottoNumber -> System.out.println(lottoNumber.getResultForPrint())
        );
    }

    public static void showWinningResult(LottoWinningResult result) {
        StringBuilder output = new StringBuilder();
        output.append("당첨 통계\n");
        output.append("---------\n");
        output.append(result.getResultForPrint());
        System.out.println(output.toString());
    }

    public static void showRateOfReturn(int purchaseAmount, long totalReward) {
        BigDecimal down = new BigDecimal(purchaseAmount);
        BigDecimal top = new BigDecimal(totalReward);
        System.out.println("총 수익률은 : " + top.divide(down, 2, RoundingMode.CEILING) + " 입니다");
    }
}
