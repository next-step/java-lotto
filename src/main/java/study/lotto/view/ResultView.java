package study.lotto.view;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoMatch;
import study.lotto.domain.LottoResult;
import study.lotto.domain.ProfitMessage;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;

import java.io.PrintStream;
import java.util.List;

public class ResultView {

    private static final PrintStream out = System.out;

    public void printBuyCount(final RequestMoney requestMoney) {
        out.printf("%s개를 구매했습니다.%n", requestMoney.getTotalLottoCount());
    }

    public void printBuyLottos(final Lottos lottos) {
        List<Lotto> lotteries = lottos.getLotteries();
        lotteries.forEach(out::println);
        out.println();
    }

    public void printStatics(final LottoResult lottoResult) {
        LottoMatch.all()
                .forEach(lottoMatch -> out.println(printFormat(lottoMatch, lottoResult)));
    }

    private String printFormat(final LottoMatch lottoMatch, final LottoResult lottoResult) {
        return String.format(
                "%s 개 일치 (%s원)- %s개"
                , lottoMatch
                , lottoMatch.getWinningReward()
                , lottoResult.count(lottoMatch));
    }

    public void printRate(final LottoResult lottoResult) {
        double rate = lottoResult.winningRate();
        out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s를 의미)%n",
                rate, ProfitMessage.of(rate));
    }
}
