package autolotto;

import autolotto.constant.Rank;
import autolotto.domain.*;
import autolotto.view.LottoInput;
import autolotto.view.LottoOutput;

import java.util.List;
import java.util.Set;

public class Lottery {
    public static void main(String[] args) {
        runLottery(createLotto(), createWinningNumbers());
    }

    private static Lottos createLotto() {
        int amount = LottoInput.askAmount();
        int totalQuantity = Lottos.getQuantity(amount);
//        int lottoQuantity = Lottos.getQuantity(amount); // remove
        int manualQuantity = LottoInput.askManualLottoQuantity();
        int autoQuantity = totalQuantity - manualQuantity;
//        LottoOutput.printQuantity(lottoQuantity); // remove

        // List<LottoNumbers> ManualLottoNumbers = createManualLotto(manualQuantity)

        LottoInput.printQuantities(manualQuantity, autoQuantity);
        List<LottoNumbers> lottoNumbers = Lottos.createLottos(autoQuantity); // -> createAutoLotto
        Lottos lottos = new Lottos(lottoNumbers);

        LottoOutput.printLottoNumbers(lottos);
        return lottos;
    }

    private static WinningLotto createWinningNumbers() {
        Set<LottoNumber> winningNumbers = LottoInput.askWinningNumber();
        LottoNumber bonusBall = LottoInput.askBonusBall(winningNumbers);

        return new WinningLotto(new LottoNumbers(winningNumbers), bonusBall);
    }

    private static void runLottery(Lottos lottos, WinningLotto winningLotto) {
        Results results = lottos.confirm(winningLotto);

        LottoOutput.printBoard();
        for (Rank rank : Rank.valuesExceptMiss()) {
            int countOfWinners = results.countOfWinners(rank);
            LottoOutput.printResult(rank, countOfWinners);
        }
        LottoOutput.printROI(results.roi(lottos.cost()));
    }
}
