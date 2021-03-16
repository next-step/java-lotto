package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoStatistics;

import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PRINT_LOTTO_COUNT = "%d개를 구매했습니다.\n";
    private static final String PRINT_LOTTO_STATICS = "당첨 통계";
    private static final String PRINT_DOTTED_LINE = "--------";
    private static final String PRINT_BENEFIT = "이득";
    private static final String PRINT_LOSS = "손해";
    private static final String PRINT_LOTTO_EARNING_RATE
            = "총 수익률은 %.2f입니다.(기준은 1이기 때문에 결과적으로 %s란 얘기)\n";


    public void printLottoCount(int lottoCount) {
        System.out.printf(PRINT_LOTTO_COUNT,lottoCount);
    }
    
    public void printLottoList(LottoList lottoList) {
        String printLottolist = "";
        for (Lotto lotto : lottoList.getLottoList()) {
            printLottolist += "[";
            printLottolist += printEachLotto(lotto);
            printLottolist += "]\n";
        }
        System.out.println(printLottolist.trim());
    }

    private String printEachLotto(Lotto lotto) {
        return lotto.getLottoNumberList()
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    public void printLottoStatics(LottoStatistics lottoStatistics) {
        System.out.println(PRINT_LOTTO_STATICS);
        System.out.println(PRINT_DOTTED_LINE);
        System.out.println(lottoStatistics.toString());
    }

    public void printLottoEarningRate(double earningRate, boolean isBenefit) {
        String benefitOrLoss = (isBenefit) ? PRINT_BENEFIT : PRINT_LOSS;
        System.out.printf(PRINT_LOTTO_EARNING_RATE,earningRate,benefitOrLoss);
    }

}
