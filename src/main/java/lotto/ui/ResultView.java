package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyMethod;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.dto.RanksDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String BUY_LOTTO_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---------";
    private static final String RESULT_WINNING_MESSAGE =
            "%d개 일치 (%d원)- %d개\n" +
                    "%d개 일치 (%d원)- %d개\n" +
                    "%d개 일치 (%d원)- %d개\n" +
                    "%d개 일치, 보너스 볼 일치(%d원)- %d개\n" +
                    "%d개 일치 (%d원)- %d개\n" +
                    "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printBuyHistory(LottoBuyMethod buyMethod, Lottos lottos) {
        System.out.printf(BUY_LOTTO_MESSAGE, buyMethod.getManualCount(), buyMethod.getAutoCount());
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    private static void printLotto(List<LottoNumber> lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getValue()))
                .collect(Collectors.joining(", ")));
        sb.append(']');
        System.out.println(sb.toString());
    }

    public static void printResult(RanksDto result) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.printf(RESULT_WINNING_MESSAGE,
                result.getMatchCountOfFifth(), result.getPrizeOfFifth(), result.getCountOfFifth(),
                result.getMatchCountOfFourth(), result.getPrizeOfFourth(), result.getCountOfFourth(),
                result.getMatchCountOfThird(), result.getPrizeOfThird(), result.getCountOfThird(),
                result.getMatchCountOfSecond(), result.getPrizeOfSecond(), result.getCountOfSecond(),
                result.getMatchCountOfFirst(), result.getPrizeOfFirst(), result.getCountOfFirst(),
                result.getRateOfProfit());
    }
}
