package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        int buyLottoAmount = InputView.inputLottoBuyAmount();

        LottoSeller lottoSeller = new LottoSeller(buyLottoAmount);
        List<LottoNumberResult> lottoNumbers = lottoSeller.buyLotto(new AutoLottoNumberGenerator(),
                LottoNumber.LOTTO_NUMBERS,
                LottoNumber.LOTTO_SIZE);

        // 개수 출력 및 번호 출력
        OutputView.outputBuyCount(lottoNumbers.size());
        OutputView.outputLottoNumbers(lottoNumbers);

        // 지난주 당첨 번호 입력
        List<Integer> winnerNumbers = InputView.inputWinningNumbers();
        List<LottoMatcher> lottoMatchers = lottoSeller.matchLottoRanking(winnerNumbers, lottoNumbers);
        BigDecimal earningRate = lottoSeller.calculateEarningsRate(lottoMatchers);

        OutputView.output();
        OutputView.outputRankingStatistics(lottoMatchers);
        OutputView.outputEarningRate(earningRate);
    }
}
