package autolotto;

import autolotto.domain.*;
import autolotto.view.LottoInput;
import autolotto.view.LottoOutput;

import static autolotto.view.LottoInput.AMOUNT_QUESTION;
import static autolotto.view.LottoInput.WINNING_NUMBER_QUESTION;

public class Lottery {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();
        Lottos lottos = new Lottos();

        int amount = lottoInput.askAmount(AMOUNT_QUESTION);
        int lottoQuantity = lottos.getQuantity(amount);
        lottoOutput.println(lottoQuantity + "장을 구입했습니다.");

        for (int count = 0; count < lottoQuantity; count++) {
            Lotto lotto = new Lotto(new LottoNumbers(LottoGenerator.generate()));
            lottos.add(lotto);
            lottoOutput.println(lotto.toString());
        }

        String numbers = lottoInput.askWinningNumber(WINNING_NUMBER_QUESTION);
        WinningLotto winningLotto = new WinningLotto(numbers);

        Results results = lottos.confirm(winningLotto);

        lottoOutput.printResult(results);
        lottoOutput.printProfit(lottos, results);
    }
}
