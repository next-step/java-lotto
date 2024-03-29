package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
    public static void start() {
        long lottoMoney = InputView.inputLottoMoney();
        int allLottoCount = LottoCalculator.getAvailableLottoNumbers(lottoMoney);
        int manualLottoCount = InputView.inputManualLottoNumberCount();

        LottoCount lottoCount = new LottoCount(allLottoCount, manualLottoCount);

        List<List<Integer>> inputManualLottos = InputView.inputManualLottoNumber(lottoCount.getManualLottoCount());

        ResultView.printLottoCount(lottoCount.getManualLottoCount(), lottoCount.getAutoLottoCount());

        List<LottoNumbers> mergedLottos = getMergedLottos(getManualLottos(inputManualLottos), getAutoLottoNumbers(lottoCount.getLottoCount()));

        Lottos lottos = new Lottos(mergedLottos);

        ResultView.printLottos(lottos);

        List<Integer> winningLottoNumber = InputView.inputWinningNumber();
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());

        WinningLottoNumber bonusLottoNumber = new WinningLottoNumber(new LottoNumbers(winningLottoNumber), bonusNumber);

        LottoWinningStatistics lottoWinningStatistics = lottos.getWinningStatistics(bonusLottoNumber);

        ResultView.printWinningStatistics(lottoWinningStatistics.getLottoRanks());
        ResultView.printRateOfReturn(LottoCalculator.getRateOfReturn(lottoMoney, lottoWinningStatistics.getWinningMoney()));
    }

    private static List<LottoNumbers> getAutoLottoNumbers(int lottoCount) {
        return Stream.generate(() -> LottoShuffle.makeLottoNumbersInRange())
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private static List<LottoNumbers> getManualLottos(List<List<Integer>> inputManualLottos) {
        return inputManualLottos.stream()
                .map(LottoNumbers::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumbers> getMergedLottos(List<LottoNumbers> autoLottoNumbers, List<LottoNumbers> manualLottos) {
        return Stream.of(autoLottoNumbers, manualLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
