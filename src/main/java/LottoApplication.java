import controller.LottoController;
import domain.Lotto;
import domain.LottoMachine;
import domain.Money;
import domain.TotalTry;
import view.LottoInput;
import view.LottoOutput;

public class LottoApplication {
    public static void main(String[] args) {

        LottoInput lottoInput = new LottoInput();
        Money money = lottoInput.buyCash();
        TotalTry totalTry = new TotalTry(money.lottoCount());
        totalTry.minus(lottoInput.manualLotto());
        LottoOutput lottoOutput = new LottoOutput();
        LottoController lottoController = new LottoController();
        LottoMachine lottoMachine = new LottoMachine();
        Lotto winLotto = new Lotto(lottoMachine.randomBall(7));
        lottoOutput.haveLotto(lottoController.totalLotto(money));
        lottoOutput.winNumber(winLotto);
        int winning = lottoOutput.totalPrize(lottoController.resultReturn(winLotto));
        lottoOutput.totalProfit(money.lottoCount(), winning);
    }
}
