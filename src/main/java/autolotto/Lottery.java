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
        int lottoQuantity = Lottos.getQuantity(amount);
        LottoOutput.printQuantity(lottoQuantity);

        List<LottoNumbers> lottoNumbers = Lottos.createLottos(lottoQuantity);
        Lottos lottos = new Lottos(lottoNumbers);

        LottoOutput.printLottoNumbers(lottos);
        return lottos;
    }

    private static WinningLotto createWinningNumbers() {
        Set<Integer> winningNumbers = LottoInput.askWinningNumber();
        int bonusBall = LottoInput.askBonusBall(winningNumbers);

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
