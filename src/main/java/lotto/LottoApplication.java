package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = Money.of(InputView.inputMoney());
        LottoMachine lottoMachine = new LottoMachine(money);

        Lottos manualLottos = buyManualLottos(lottoMachine);
        Lottos autoLottos = lottoMachine.buyLottoAuto();
        OutputView.outputBuyLottoResult(manualLottos, autoLottos);

        Statistic statistic = lottoMachine.calculateStatistic(money, getWinningLotto(), manualLottos, autoLottos);
        OutputView.outputStatistics(statistic);
    }

    private static WinningLotto getWinningLotto() {
        return WinningLotto.builder()
                .winningNumbers(InputView.inputWinningLottoNumbers())
                .bonusBall(InputView.inputBonusBall())
                .build();
    }

    private static Lottos buyManualLottos(LottoMachine lottoMachine) {
        Lottos manualLottos = new Lottos();
        int willBuyManualLottoCount = InputView.inputWillBuyManualLottoCount();
        if (lottoMachine.canBuyLotto(willBuyManualLottoCount)) {
            manualLottos = lottoMachine.buyLottoManually(InputView.inputManualLottoNumbers(willBuyManualLottoCount));
        }
        return manualLottos;
    }
}
