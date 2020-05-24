package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        int buyLottoAmount = InputView.inputLottoBuyAmount();

        LottoShop lottoShop = new LottoShop(buyLottoAmount);
        List<LottoNumberResult> lottoNumbers = lottoShop.buyLotto(new AutoLottoNumberGenerator(),
                LottoNumbers.LOTTO_NUMBERS,
                LottoNumbers.LOTTO_SIZE);

        // 개수 출력 및 번호 출력
        OutputView.outputBuyCount(lottoNumbers.size());
        OutputView.outputLottoNumbers(lottoNumbers);

        // 지난주 당첨 번호 입력
        List<Lotto> winnerNumbers = InputView.inputWinningNumbers();
        Lotto bonusBall = new Lotto(InputView.inputBonusNumber());

        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(winnerNumbers, bonusBall);
        List<LottoMatcher> lottoMatchers = lottoNumbers.stream()
                .map(lottoNumberResult -> lottoNumberResult.findLottoMatchResult(lottoWinnerNumber))
                .collect(Collectors.toList());

        BigDecimal earningRate = lottoShop.calculateEarningsRate(lottoMatchers);

        OutputView.output();
        OutputView.outputRankingStatistics(lottoMatchers);
        OutputView.outputEarningRate(earningRate);
    }
}
