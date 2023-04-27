package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {
    public static void main(String[] args) {
        int lottoCount = InputView.calculateLottoCount();

        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoTickets lottoTickets = lottoGenerator.generate(lottoCount);
        ResultView.showLottoTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.getWinningNumbers();

        LottoGame lottoGame = new LottoGame(lottoTickets, winningNumbers);
        LottoResult lottoResult = lottoGame.getLottoResult();

        ResultView.showLottoWinningResult(lottoResult);
    }
}
