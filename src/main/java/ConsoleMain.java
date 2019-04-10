import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new LottoMoney(InputView.inputMoney()));
        ResultView.printBuyLotto(lottoMachine.getTryNo());
        List<Lotto> lottos = lottoMachine.generateLotto();
        ResultView.printLottos(lottos);
        ResultView.printStatics(new LottoResult(lottos, new WinningLotto(new Lotto(InputView.inputWinningNumbers()), InputView.inputBonusNumber())));
    }
}
