package lotto;

import lotto.domains.Cash;
import lotto.domains.LottoMachine;
import lotto.domains.LottoNumbers;
import lotto.domains.Lottos;
import lotto.ui.InputUI;
import lotto.ui.OutputUI;
import lotto.util.Convertor;

public class Main {
    public static void main(String[] args) {
        //로또 구매 단계
        OutputUI.printInputPurchasingAmount();
        int amount = InputUI.inputPurchasingAmount();
        Lottos lottos = LottoMachine.makeLottos(new Cash(amount));
        OutputUI.printNumberOfPurchases(lottos.count());
        OutputUI.printLottosNumbers(lottos);

        //당첨번호 입력 단계
        OutputUI.printInputWinningLottoNumbers();
        String stringWinningNumbers = InputUI.inputWinningNumbers();
        OutputUI.printInputBonusNumber();
        int bonusNumber = InputUI.inputBonusNumber();

        //통계 출력 단계
        LottoNumbers winningNumbers = new LottoNumbers(Convertor.convertStringToList(stringWinningNumbers));
        lottos.matchingWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        OutputUI.printStatistics(lottos);
        OutputUI.printRateOfReturn(lottos);
    }
}
