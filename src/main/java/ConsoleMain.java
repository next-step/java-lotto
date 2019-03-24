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

        WinningLotto winningLotto = new WinningLotto(ConsoleInputView.inputWinningNumbers(), ConsoleInputView.inputBonusNumber());
        lottoMachine.initWinningLotto(winningLotto);

        LottoResult lottoResult = lottoMachine.createLottoResult(lottos);
        ConsoleResultView.printTotalResult(
            lottoResult.getRankGroup(),
            lottoResult.calculateProfitRate());
    }
}
