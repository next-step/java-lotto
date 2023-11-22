package lotto.view;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoWallet;
import lotto.domain.Prize;
import lotto.domain.StatisticsReport;

public class ResultView {

    private final static String LOTTO_PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다. \n";

    private final PrintStream sout;

    public ResultView(PrintStream sout) {
        this.sout = sout;
    }
    
    public void calculateResult(int result) {
        sout.printf(LOTTO_PURCHASE_RESULT_MESSAGE, result);
    }

    public void out(LottoWallet lottoWallet) {
        for (int i = 0; i < lottoWallet.totalTicketCount(); i++){
            sout.println(lottoNumbers(lottoWallet.oneTicket(i)));
        }
    }
    private String lottoNumbers(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        lotto.lottoNumbers().forEach(lottoNumber -> {
            stringBuilder.append(lottoNumber.toString()).append(",");
        });
        int lastIndexOf = stringBuilder.lastIndexOf(",");
        stringBuilder.replace(lastIndexOf, lastIndexOf + 1, "]");
        return stringBuilder.toString();
    }

    public void resultOut() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(Prize.values()).forEach(prize -> {
            if(prizeRankOver3Under6(prize)){
                createStringBuilderWithPrize(prize, stringBuilder);
            }
        });
        stringBuilder.append("5개 일치, 보너스 볼 일치");
        stringBuilder.append(" (").append(Prize.BONUS.price()).append(")-");
        stringBuilder.append(Prize.BONUS.rank().getRank()).append("개 \n");

        createStringBuilderWithPrize(Prize.FIRST, stringBuilder);
        sout.print(stringBuilder.toString());
    }

    private static void createStringBuilderWithPrize(Prize prize, StringBuilder stringBuilder) {
        stringBuilder.append(prize.rank().toString());
        stringBuilder.append("개 일치");
        stringBuilder.append(" (").append(prize.price()).append(")-");
        stringBuilder.append(prize.rank().getScore()).append("개 \n");
    }

    private static boolean prizeRankOver3Under6(Prize prize) {
        return 3 <= prize.rank().getRank();
    }

    public void out(BigDecimal rate) {
        DecimalFormat decimalFormat = new DecimalFormat();
        sout.printf("총 수익률은 %s 입니다. \n", decimalFormat.format(rate));
    }
}