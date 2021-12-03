package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoRandomMachine;
import lotto.domain.LottoTickets;
import lotto.domain.ResultLotto;
import lotto.domain.Wallet;
import lotto.dto.AssignPreTicket;
import lotto.dto.BuyTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = InputView.create();
        Wallet wallet = inputView.inputMoney();

        AssignPreTicket assignPreTicket = inputView.inputAssignNumberCount(
            wallet);// 갯수는도 저장해야 하는데?
        LottoTickets lottoTickets1 = inputView.inputAssignNumber(assignPreTicket);

        BuyTickets resultDto = assignPreTicket.getResultDto(lottoTickets1,
            new LottoRandomMachine());

        OutputView outputView = new OutputView();
        outputView.printBuyCountMessage(resultDto);
        ResultLotto resultLotto = inputView.inputLottoResultNumber();

        GameResult result = resultDto.result(resultLotto);
        outputView.printByResult(result);

    }

}
