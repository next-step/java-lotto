import controller.LottoController;
import domain.Lotto;
import domain.LottoMachine;
import domain.Money;
import view.LottoInput;
import view.LottoOutput;

public class LottoApplication {
    public static void main(String[] args) {

        Money money = new LottoInput().buyCash();
        LottoOutput lottoOutput = new LottoOutput();
        LottoController lottoController = new LottoController();
        LottoMachine lottoMachine = new LottoMachine();
        Lotto winLotto = new Lotto(lottoMachine.winBall());
        lottoOutput.haveLotto(lottoController.totalLotto(money.lottoCount()));
        lottoOutput.winNumber(winLotto);
        int winning = lottoOutput.totalPrize(lottoController.resultReturn(winLotto));
        lottoOutput.totalProfit(money.lottoCount(), winning);
    }
}
