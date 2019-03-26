import domain.*;
import view.ConsoleInputView;
import view.ConsoleResultView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        LottoMoney lottoMoney = new LottoMoney(ConsoleInputView.inputPrice());
        LottoPaper lottoPaper = new LottoPaper(lottoMoney);

        lottoPaper.fillManuals(ConsoleInputView.inputManualLottoNumbers(ConsoleInputView.inputManualLottoCount()));

        List<Lotto> lottos = lottoMachine.purchase(lottoPaper);
        
        ConsoleResultView.printLottoCount(lottoPaper);
        ConsoleResultView.printLottosInfo(lottos);

        WinningLotto winningLotto = new WinningLotto(ConsoleInputView.inputWinningNumbers(), ConsoleInputView.inputBonusNumber());
        lottoMachine.initWinningLotto(winningLotto);

        LottoResult lottoResult = lottoMachine.createLottoResult(lottos);
        ConsoleResultView.printTotalResult(
            lottoResult.getRankGroup(),
            lottoResult.calculateProfitRate());
    }
}
