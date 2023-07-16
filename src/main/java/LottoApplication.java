import config.AppConfig;
import controller.LottoController;
import domain.LottoResult;
import domain.Lottos;
import domain.WinningLotto;
import view.InputReader;
import view.OutputWriter;

import java.util.List;

public class LottoApplication {

    private final LottoController lottoController;
    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public LottoApplication() {
        this.lottoController = AppConfig.lottoController();
        this.inputReader = AppConfig.inputReader();
        this.outputWriter = AppConfig.outputWriter();
    }

    public static void main(String[] args) {
        try {
            new LottoApplication().run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("예상하지 못한 예외가 발생했습니다.");
        }
    }

    public void run() {
        final long inputMoney = inputReader.readMoneyValue();
        final Lottos autoLottos = lottoController.generateAutoLottos(inputMoney);
        outputWriter.printLottosInfo(autoLottos);

        final List<Integer> lotto = inputReader.readLottoValue();
        final int bonus = inputReader.readLottoNumberValue();
        final WinningLotto winningLotto = lottoController.generateWinningLotto(lotto, bonus);

        final LottoResult lottoResult = lottoController.result(autoLottos, winningLotto);
        outputWriter.printLottoResultStatistic(lottoResult, inputMoney);
    }
}
