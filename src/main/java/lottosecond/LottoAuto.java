package lottosecond;

import lottosecond.domain.EarningRateCalculator;
import lottosecond.domain.LottoBuyMoney;
import lottosecond.domain.WinnerBoard;
import lottosecond.domain.WinningCondition;
import lottosecond.domain.lotto.*;
import lottosecond.view.InputView;
import lottosecond.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAuto {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Lottos lottos = LottosMaker.makeLottoList(new LottoShuffler(), new LottoBuyMoney(inputView.inputLottoBuyMoney()));
        outputView.printLottoListInfo(lottos);

        String winNumbersString = inputView.inputWinningNumbers();
        Lotto winningLotto = extractWinningLotto(winNumbersString);

        int bonusNumber = inputView.inputBonusNumber();
        WinningCondition winningCondition = new WinningCondition(winningLotto, LottoNumber.of(bonusNumber));

        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningCondition);
        outputView.printWinnerStatistics(winnerBoard);

        EarningRateCalculator earningRateCalculator = new EarningRateCalculator();
        double earningRate = earningRateCalculator.calculateEarningRate(winnerBoard, lottos);
        outputView.printEarningRate(earningRate);
    }

    private static Lotto extractWinningLotto(String winNumbersString) {
        List<Integer> collect = Arrays.stream(winNumbersString.split(","))
                .map(strNumber -> Integer.parseInt(strNumber.strip()))
                .collect(Collectors.toList());

        return new Lotto(collect);
    }
}
