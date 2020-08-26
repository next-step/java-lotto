import step2.domain.*;
import step2.domain.view.InputView;
import step2.domain.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputMoney = inputView.inputMoney();

        int lottoCount = LottoMachine.getCount(inputMoney);
        LottoTicket lottoTicket = LottoNumbers.create(lottoCount);

        OutputView outputView = new OutputView();
        outputView.viewLottoNumbers(lottoTicket);

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.inputWinningNumbers());
        LottoResult lottoResult = lottoTicket.getMatching(winningLottoNumbers);

        outputView.viewResult(lottoResult, inputMoney);

    }
}
