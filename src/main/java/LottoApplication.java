import controller.LottoController;
import domain.Lotto;
import domain.LottoMachine;
import view.LottoInput;
import view.LottoOutput;

public class LottoApplication {
    public static void main(String[] args) {

        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();
        LottoController lottoController = new LottoController();
        LottoMachine lottoMachine = new LottoMachine();
        Lotto winLotto = lottoMachine.pull();
        int totalBuy = lottoInput.buyCash();

        lottoController.run(totalBuy);
        lottoOutput.myLottoPrint(lottoController.getMyLotto());
        lottoOutput.winNumber(winLotto);
        int winning = lottoOutput.totalPrize(lottoController.resultReturn(winLotto));
        lottoOutput.totalProfit(totalBuy, winning);
    }
}
