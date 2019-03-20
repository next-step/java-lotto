import domain.*;
import view.ConsoleInputView;
import view.ConsoleResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottos = lottoMachine.purchase(ConsoleInputView.inputPrice());
        ConsoleResultView.printLottoCount(lottos);
        ConsoleResultView.printLottosInfo(lottos);

        lottoMachine.initWinningNumbers(ConsoleInputView.inputWinningNumbers());

        List<Rank> ranks = lottoMachine.calculateRanks(lottos);
        ConsoleResultView.printTotalResult(
            LottoAnalyzer.makeWinGroup(ranks),
            LottoAnalyzer.calculateProfitRate(ranks));
    }
}
