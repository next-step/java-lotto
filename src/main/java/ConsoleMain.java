import domain.*;
import view.ConsoleInputView;
import view.ConsoleResultView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney(ConsoleInputView.inputPrice());
        List<Integer[]> manualNumbers = ConsoleInputView.inputManualLottoNumbers(ConsoleInputView.inputManualLottoCount());
        LottoGenerator lottoGenerator = new DefaultLottoGenerator(lottoMoney, manualNumbers);

        List<Lotto> lottos = lottoGenerator.generate();
        
        ConsoleResultView.printLottoCount(manualNumbers.size(), lottoMoney.getLottoCount() - manualNumbers.size());
        ConsoleResultView.printLottosInfo(lottos);

        WinningLotto winningLotto = new WinningLotto(ConsoleInputView.inputWinningNumbers(), ConsoleInputView.inputBonusNumber());

        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        ConsoleResultView.printTotalResult(
            lottoResult.getRankGroup(),
            lottoMoney.calculateProfitRate(lottoResult.calculatePrizeMoney()));
    }
}
