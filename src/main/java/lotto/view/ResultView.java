package lotto.view;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoWallet;
import lotto.domain.LottoRank;
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

    public void resultOut(StatisticsReport report) {
        IntStream.range(0, LottoRank.values().length).forEach(i -> {
                LottoRank lottoRank = LottoRank.values()[i];
                if(lottoRank.equals(LottoRank.SECOND)){
                    System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d 개", i, lottoRank.prize(), report.count(lottoRank));
                }else{
                    System.out.printf("%d개 일치(%d원) - %d 개", i, lottoRank.prize(), report.count(lottoRank));
                }
        });
    }

    public void out(BigDecimal rate) {
        DecimalFormat decimalFormat = new DecimalFormat();
        sout.printf("총 수익률은 %s 입니다. \n", decimalFormat.format(rate));
    }
}
