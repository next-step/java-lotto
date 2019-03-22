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

        Lotto winningNumbers = new Lotto(ConsoleInputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.getInstance(ConsoleInputView.inputBonusNumber());
        lottoMachine.initWinningLotto(new WinningLotto(winningNumbers, bonusNumber));

        LottoResult lottoResult = lottoMachine.createLottoResult(lottos);
        ConsoleResultView.printTotalResult(
            lottoResult.getRankGroup(),
            lottoResult.calculateProfitRate());
    }
}
