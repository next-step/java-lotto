import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.LottoMachine;
import step2.domain.WinningLottoNumbers;
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

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.inputWinningNumbers());
        LottoResult lottoResult = new LottoResult(lottoTicket, winningLottoNumbers);
        outputView.viewResult(lottoResult.getResultMap(), lottoMoney);

    }
}
