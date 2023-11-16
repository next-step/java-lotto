package lottosecond;

import lottosecond.domain.EarningRateCalculator;
import lottosecond.domain.WinnerBoard;
import lottosecond.domain.lotto.LottoNumber;
import lottosecond.domain.lotto.LottoShuffler;
import lottosecond.domain.lotto.Lottos;
import lottosecond.domain.lotto.LottosMaker;
import lottosecond.view.InputView;
import lottosecond.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAuto {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Lottos lottos = LottosMaker.makeLottoList(new LottoShuffler(), inputView.inputLottoBuyMoney());
        outputView.printLottoListInfo(lottos);

        String winNumbersString = inputView.inputWinningNumbers();
        List<LottoNumber> winningNumbers = extractWinningNumbers(winNumbersString);

        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningNumbers);
        outputView.printWinnerStatistics(winnerBoard);

        EarningRateCalculator earningRateCalculator = new EarningRateCalculator();
        double earningRate = earningRateCalculator.calculateEarningRate(winnerBoard, lottos);
        outputView.printEarningRate(earningRate);
    }

    private static List<LottoNumber> extractWinningNumbers(String winNumbersString) {
        return Arrays.stream(winNumbersString.split(","))
                .map(strNumber -> Integer.parseInt(strNumber.strip()))
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
