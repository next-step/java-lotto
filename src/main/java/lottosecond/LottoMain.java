package lottosecond;

import lottosecond.domain.*;
import lottosecond.domain.lotto.*;
import lottosecond.domain.lottomaker.AutoLottoNumberGenerator;
import lottosecond.domain.lottomaker.AutoLottoMaker;
import lottosecond.domain.lottomaker.ManualLottoMaker;
import lottosecond.view.InputView;
import lottosecond.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Money money = new Money(inputView.inputLottoBuyMoney());
        TotalLottoCount lottoCount = new TotalLottoCount(money, inputView.manualLottoCount());

        ManualLottoMaker manualLottoMaker = new ManualLottoMaker();
        AutoLottoMaker autoLottoMaker = new AutoLottoMaker(new AutoLottoNumberGenerator());

        inputView.printManualLottos();
        List<String> stringLottoNumbers = inputView.inputManualLottoNumbers(lottoCount.manualLottoCount());

        Lottos manualLottos = manualLottoMaker.makeLottos(stringListToIntegerListConvert(stringLottoNumbers));
        Lottos autoLottos = autoLottoMaker.makeLottos(lottoCount.getAutoLottoCount());

        Lottos lottos = Lottos.makeTotalLottos(manualLottos, autoLottos);

        outputView.printManualAndAutoLottoInfo(lottoCount);
        outputView.printLottoListInfo(lottos);

        String winningLottoNumbers = inputView.printWinningNumbers();
        Lotto winningLotto = manualLottoMaker.makeLotto(stringToIntegerConvert(winningLottoNumbers));

        WinningCondition winningCondition = new WinningCondition(winningLotto, LottoNumber.of(inputView.inputBonusNumber()));

        WinnerBoard winnerBoard = lottos.checkWinnerLotto(winningCondition);
        outputView.printWinnerStatistics(winnerBoard);

        EarningRateCalculator earningRateCalculator = new EarningRateCalculator();
        double earningRate = earningRateCalculator.calculateEarningRate(winnerBoard, money);
        outputView.printEarningRate(earningRate);
    }

    private static List<List<Integer>> stringListToIntegerListConvert(List<String> lottoNumberList) {
        return lottoNumberList.stream().map(lottoNumbers -> Arrays.stream(lottoNumbers.split(","))
                        .map(stringNumber -> Integer.valueOf(stringNumber.strip()))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static List<Integer> stringToIntegerConvert(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(","))
                .map(stringNumber -> Integer.valueOf(stringNumber.strip()))
                .collect(Collectors.toList());
    }
}
