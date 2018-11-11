package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoDto;
import lotto.domain.LottoGame;
import lotto.domain.LottoGameResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int budget = InputView.getBudget();

        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.makeLotto(budget);

        int lottoCount = lottoGame.getLottoCount(budget);
        ResultView.showLottoCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            ResultView.showLottoNumbers(lottos.get(i));
        }

        List<LottoDto> lottoDtos = new ArrayList<>();

        List<Integer> winningNumbers = InputView.getWinningNumber();
        LottoGameResult lottoGameResult = new LottoGameResult();

        LottoDto lottoDto = lottoGameResult.getLottoResultForThree(lottos, winningNumbers);
        ResultView.showResult(lottoDto);
        lottoDtos.add(lottoDto);

        lottoDto = lottoGameResult.getLottoResultForFour(lottos, winningNumbers);
        ResultView.showResult(lottoDto);
        lottoDtos.add(lottoDto);

        lottoDto = lottoGameResult.getLottoResultForFive(lottos, winningNumbers);
        ResultView.showResult(lottoDto);
        lottoDtos.add(lottoDto);

        lottoDto = lottoGameResult.getLottoResultForSix(lottos, winningNumbers);
        ResultView.showResult(lottoDto);
        lottoDtos.add(lottoDto);

        String ratio = lottoGameResult.getRatio(lottoDtos, budget);
        ResultView.showRatioResult(ratio);
    }
}
