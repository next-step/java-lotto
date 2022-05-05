package autolotto;

import autolotto.constant.Rank;
import autolotto.domain.*;
import autolotto.view.LottoInput;
import autolotto.view.LottoOutput;

import java.util.Set;

public class Lottery {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();
        Lottos lottos = new Lottos();

        int amount = lottoInput.askAmount();
        int lottoQuantity = lottos.getQuantity(amount);
        lottoOutput.printQuantity(lottoQuantity);

        lottos.createLotto(lottoQuantity);
        for (LottoNumbers lottoNumber : lottos.getLottoNumbers()) {
            lottoOutput.println(lottoNumber.toString());
        }

        Set<Integer> winningNumbers = lottoInput.askWinningNumber();
        int bonusBall = lottoInput.askBonusBall(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(winningNumbers), bonusBall);

        Results results = lottos.confirm(winningLotto);

        lottoOutput.printBoard();
        for (Rank rank : Rank.valuesExceptMiss()) {
            int countOfWinners = results.countOfWinners(rank);
            lottoOutput.printResult(rank, countOfWinners);
        }
        lottoOutput.printROI(results.roi(lottos.cost()));
    }
}
