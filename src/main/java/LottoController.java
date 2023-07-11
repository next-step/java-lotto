import lottogame.LottoService;
import lottogame.Payment;
import lottogame.WinningNumber;
import view.LottoView;

public class LottoController {

    public void run() {
        LottoView lottoView = new LottoView();

        Payment payment = new Payment(lottoView.readPayment());
        LottoService lottoService = new LottoService(payment);
        lottoView.printLottoCount(lottoService.getCount());
        lottoView.printLottos(lottoService.getLottos());

        String winningLotto = lottoView.readWinningLotto();
        String bonusBall = lottoView.readBonusBall();
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusBall);

        lottoView.printResult(lottoService.getResult(winningNumber));
        lottoView.printProfitRate(lottoService.getProfitRate());
    }
}
