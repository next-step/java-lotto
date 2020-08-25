import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.LottoMachine;
import step2.domain.WinningLottoNumber;
import step2.domain.view.InputView;
import step2.domain.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoMachine lottoMachine = new LottoMachine();
        String lottoMoney = inputView.inputMoney();
        LottoTicket lottoTicket = lottoMachine.makeLotto(lottoMoney);

        OutputView outputView = new OutputView();
        outputView.viewLottoNumbers(lottoTicket);

        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(inputView.inputWinningNumbers());
        LottoResult lottoResult = new LottoResult(lottoTicket, winningLottoNumber);
        outputView.viewResult(lottoResult.getResultMap(), lottoMoney);

    }
}
