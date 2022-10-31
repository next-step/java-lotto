package lotto;

public class LottoMain {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(Money.of(InputView.inputMoney()));
        Lottos manualLottos = new Lottos();
        int willBuyManualLottoCount = InputView.inputWillBuyManualLottoCount();
        if (lottoMachine.canBuyLotto(willBuyManualLottoCount)) {
            manualLottos = lottoMachine.buyLottoManually(InputView.inputManualLottoNumbers(willBuyManualLottoCount));
        }
        Lottos autoLottos = lottoMachine.buyLottoAuto();

        OutputView.outputBuyLottoResult(manualLottos, autoLottos);

        WinningLotto winningLotto = WinningLotto.builder()
                .winningNumbers(InputView.inputWinningLottoNumbers())
                .bonusBall(InputView.inputBonusBall())
                .build();

        Statistic statistic = lottoMachine.calculateStatistic(manualLottos, autoLottos, winningLotto);
        OutputView.outputStatistics(statistic);
    }
}
