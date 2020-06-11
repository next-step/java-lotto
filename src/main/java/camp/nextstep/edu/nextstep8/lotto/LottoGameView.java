package camp.nextstep.edu.nextstep8.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

public class LottoGameView {

    public static void showLottoTicket(LottoTicket lottoTicket) {
        for (LottoNumber lottoNumber : lottoTicket.getLottoNumbers()) {
            System.out.println(lottoNumber);
        }
    }

    public static void showWinningResult(LottoWinningResult result) {
        StringBuilder output = new StringBuilder();
        output.append("당첨 통계\n");
        output.append("---------\n");
        Arrays.stream(LottoAward.values())
                .sorted(Comparator.comparingInt(LottoAward::getCondition))
                .forEach(e -> {
                    output.append(e.getCondition() + "개 일치 (" + e.getPrize() + "원) -\t");
                    output.append(result.getWinningCount(e) + "개 \n");
                });
        System.out.println(output.toString());
    }

    public static void showRateOfReturn(int purchaseAmount, long totalReward) {
        BigDecimal down = new BigDecimal(purchaseAmount);
        BigDecimal top = new BigDecimal(totalReward);
        System.out.println("총 수익률은 : " + top.divide(down, 2, RoundingMode.CEILING) + " 입니다");
    }
}
