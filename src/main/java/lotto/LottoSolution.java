package lotto;

import lotto.domain.*;
import lotto.domain.dto.LottoBuyInfo;
import lotto.domain.dto.WinningLottoInfo;
import lotto.exception.InvalidInputException;
import lotto.util.number.CalculationNumber;
import lotto.util.number.DivisionNumber;
import lotto.util.number.SubtractionNumber;
import lotto.view.DosInputView;
import lotto.view.DosResultView;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoSolution {
    public static void main(String[] args) {
        LottoSolution lottoSolution = new LottoSolution(
                new DosInputView(), new DosResultView()
        );
        lottoSolution.run();
    }

    private final InputView inputView;
    private final ResultView resultView;

    public LottoSolution(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            LottoBuyInfo lottoBuyInfo = inputView.inputLottoBuyInfo();
            LottoList lottoList = buyLottoList(lottoBuyInfo);
            resultView.printLottoList(lottoList, lottoBuyInfo.manualLottoSize());

            WinningLottoInfo winningLottoInfo = inputView.inputWinningLottoInfo();
            WinningLotto winningLotto = inputWinningLottoNumbers(winningLottoInfo);

            LottoStatistics lottoStatistics = lottoList.statistics(winningLotto);
            resultView.printLottoStatistics(lottoStatistics);
        } catch (Exception e) {
            resultView.printException(e);
        }
    }

    private LottoList buyLottoList(LottoBuyInfo buyInfo) {
        List<Lotto> manualLottoList =
                buyInfo.manualLottoList().stream()
                        .map(Lotto::of)
                        .collect(Collectors.toList());

        CalculationNumber autoLottoSize = new SubtractionNumber(
                new DivisionNumber(buyInfo.money(), Lotto.PRICE),
                manualLottoList.size()
        );

        if (autoLottoSize.isNegative()) {
            throw new InvalidInputException("로또를 구매할 금액이 부족합니다.");
        }
        return newLottoList(autoLottoSize, manualLottoList);
    }

    private LottoList newLottoList(CalculationNumber autoLottoSize, List<Lotto> manualLottoList) {
        if (autoLottoSize.isPositive()) {
            return LottoList.generate(autoLottoSize)
                    .add(manualLottoList);
        }
        return new LottoList(manualLottoList);
    }

    private WinningLotto inputWinningLottoNumbers(WinningLottoInfo winningLottoInfo) {
        String strWiningNumbers = winningLottoInfo.lottoNumbers();
        int bonusNumber = winningLottoInfo.bonusNumber();

        return new WinningLotto(
                Lotto.of(strWiningNumbers), LottoNumber.of(bonusNumber)
        );
    }
}
