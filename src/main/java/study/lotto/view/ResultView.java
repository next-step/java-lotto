package study.lotto.view;

import study.lotto.domain.Lotto;
import study.lotto.domain.type.LottoMatch;
import study.lotto.domain.LottoResult;
import study.lotto.domain.type.ProfitMessage;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;

import java.io.PrintStream;
import java.util.List;

public class ResultView {

    private static final String GUIDE_BUY_LOTTO = "%s개를 구매했습니다.%n";
    private static final String GUIDE_PROFIT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s를 의미)%n";
    private static final PrintStream out = System.out;

    public static void printLottoCount(final RequestMoney requestMoney) {
        out.printf(GUIDE_BUY_LOTTO, requestMoney.divideMoneyByPrice());
    }

    public static void printLottos(final Lottos lottos) {
        List<Lotto> lotteries = lottos.lottoList();
        lotteries.forEach(out::println);
        out.println();
    }

    public static void printResult(final LottoResult lottoResult) {
        LottoMatch.all()
                .forEach(lottoMatch -> out.println(format(lottoMatch, lottoResult)));
    }

    private static String format(final LottoMatch lottoMatch, final LottoResult lottoResult) {
        return String.format(
                lottoMatch.guideLine()
                , lottoMatch
                , lottoMatch.getWinningReward()
                , lottoResult.count(lottoMatch));
    }

    public static void printRate(final LottoResult lottoResult) {
        double rate = lottoResult.winningRate();
        out.printf(GUIDE_PROFIT, rate, ProfitMessage.of(rate));
    }
}
