import domain.*;
import view.ConsoleInputView;
import view.ConsoleResultView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        LottoMoney lottoMoney = new LottoMoney(ConsoleInputView.inputPrice());
        List<Integer[]> manualNumbers = ConsoleInputView.inputManualLottoNumbers(ConsoleInputView.inputManualLottoCount());
        LottoGenerator lottoGenerator = new DefaultLottoGenerator(lottoMoney, manualNumbers);

        List<Lotto> lottos = lottoGenerator.generate();
        
        ConsoleResultView.printLottoCount(manualNumbers.size(), lottoMoney.getLottoCount() - manualNumbers.size());
        ConsoleResultView.printLottosInfo(lottos);

        WinningLotto winningLotto = new WinningLotto(ConsoleInputView.inputWinningNumbers(), ConsoleInputView.inputBonusNumber());
        lottoMachine.initWinningLotto(winningLotto);

        LottoResult lottoResult = lottoMachine.createLottoResult(lottos);
        ConsoleResultView.printTotalResult(
            lottoResult.getRankGroup(),
            lottoResult.calculateProfitRate());
    }
}
