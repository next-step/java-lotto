package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Optional;

public class LottoRunner {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        Lottos autoLottos = this.makeLottosAuto();
        Lottos manualLottos = this.makeLottosManual();
        Lottos lottos = this.sumMadeLottos(autoLottos, manualLottos);

        this.win(lottos).ifPresent(lottoWinResult -> this.printResult(lottoWinResult, lottos));
    }

    /**
     * 구매한 금액 만큼 로또 번호들을 뽑습니다.
     */
    private Lottos makeLottosAuto() {
        return new Lottos(this.inputView.getAutoLottoCount());
    }

    /**
     * 수동으로 로또 번호들을 뽑습니다.
     */
    private Lottos makeLottosManual() {
        return this.inputView.getManualLottos(this.inputView.getManualLottoCount());
    }

    /**
     * 수동, 자동으로 발급된 로또들을 합치고 번호를 출력합니다.
     * @param autoLottos
     * @param manualLottos
     * @return
     */
    private Lottos sumMadeLottos(Lottos autoLottos, Lottos manualLottos) {
        this.resultView.printNumberOfPurchasedLotto(manualLottos.size(), autoLottos.size());
        manualLottos.addLottos(autoLottos);
        this.resultView.printLottoNumbers(manualLottos);
        return manualLottos;
    }

    /**
     * 당첨번호를 입력하고 결과를 계산합니다..
     * @param lottos
     * @return
     */
    private Optional<LottoWinResult> win(Lottos lottos) {
        Optional<Lotto> winLottoNumbers = this.inputView.insertWinLottoNumbers();
        Optional<LottoNumber> bonusNumber = this.inputView.insertBonusNumber();

        if(winLottoNumbers.isPresent() && bonusNumber.isPresent()) {
            LottoWinCalculator lottoWinCalculator
                    = new LottoWinCalculator(winLottoNumbers.get(), bonusNumber.get());
            return Optional.of(lottoWinCalculator.findLottoWinPrize(lottos));
        }
        return Optional.empty();
    }

    /**
     * 당첨 케이스 별 당첨 된 수와 수익률을 출력합니다.
     * @param lottoWinResult
     */
    private void printResult(LottoWinResult lottoWinResult, Lottos lottos) {
        this.resultView.printWinStatistics(lottoWinResult);
        this.resultView.printPriceEarningRatio(lottoWinResult.calculatePriceEarningRatio(lottos.size()));
    }
}
