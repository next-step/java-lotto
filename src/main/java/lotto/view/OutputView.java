package lotto.view;

import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeSummary;
import lotto.domain.Profit;
import lotto.view.formatter.OutputFomatter;
import lotto.view.printer.Printer;

public class OutputView {
    private final Printer printer;
    private final OutputFomatter formatter;

    public OutputView(Printer printer, OutputFomatter formatter) {
        this.printer = printer;
        this.formatter = formatter;
    }

    public void printLottoCount(LottoCount lottoCount) {
        int count = formatter.toLottoCount(lottoCount);
        printer.printLine("%d개를 구매했습니다.", count);
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(this::printLotto);
    }

    private void printLotto(Lotto rawLotto) {
        String lotto = formatter.toLotto(rawLotto);
        printer.printLine("[%s]", lotto);
    }

    public void printPrizeSummary(PrizeSummary prizeSummary) {
        printer.printLine("당첨 통계");
        printer.printLine("---------");
        prizeSummary.getPrizeSummary().entrySet().forEach(prizeDetail -> printPrizeDetail(prizeDetail));
    }

    private void printPrizeDetail(Entry<Prize, Integer> rawPrizeDetail) {
        if (rawPrizeDetail.getKey() != Prize.NOTHING) {
            int matchingCount = formatter.toMatchingCount(rawPrizeDetail);
            int prizeAmount = formatter.toPrizeAmount(rawPrizeDetail);
            int prizeCount = formatter.toPrizeCount(rawPrizeDetail);

            printer.printLine("%d개 일치 (%d원)- %d개", matchingCount, prizeAmount, prizeCount);
        }
    }

    public void printProfit(Profit rawProfit) {
        double profit = formatter.toProfit(rawProfit);
        printer.printLine("총 수익률은 %.2f입니다.", profit);
    }
}
