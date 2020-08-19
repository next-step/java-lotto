package nextstep.lotto;

import nextstep.lotto.dto.LottoRank;
import nextstep.lotto.dto.LottoResultBoard;
import nextstep.lotto.dto.LottoTicket;
import nextstep.lotto.utils.LottoNumberUtil;
import nextstep.lotto.view.InputView;
import nextstep.lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static nextstep.lotto.dto.LottoResultBoard.LOTTO_VALUE;

public class LottoGame {

    private InputView inputView;
    private ResultView resultView;
    private LottoResultBoard resultBoard;

    public LottoGame() {
        inputView = new InputView();
        resultView = new ResultView();
        resultBoard = new LottoResultBoard();
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.playLottoGame();
    }

    private void playLottoGame() {
        int moneyAmount = inputView.inputTotalAmountForBuy();

        List<LottoTicket> userLottoTicket = buyTicket(howManyBuyLottoTicket(moneyAmount));
        resultView.showLottoTicket(userLottoTicket);

        LottoTicket winnerTicket = castWinnerNumber(inputView.inputWinnerNumber());

        resultLotto(userLottoTicket,winnerTicket);
    }

    private void resultLotto(List<LottoTicket> userLottoTicket,LottoTicket winnerTicket){
        for(LottoTicket ticket : userLottoTicket){
            LottoRank lottoResult = LottoRank.of(ticket.matchCount(winnerTicket.getLottoNumber()));
            resultBoard.addLottoResult(lottoResult);
        }

        resultView.showLottoResultBoard(resultBoard.getLottoResult(),resultBoard.getBenefitRate());
    }
    private LottoTicket castWinnerNumber(List<String> winnerNumbers) {
        return LottoTicket.create(
                LottoNumberUtil.transStringNumberToLottoNumber(winnerNumbers)
        );
    }


    private List<LottoTicket> buyTicket(int buyTicketCount) {
        List<LottoTicket> tickets = new ArrayList<>();

        for(int i = 0; i < buyTicketCount; i++){
            tickets.add(LottoTicket.create(LottoNumberUtil.generator()));
        }

        return tickets;
    }
    private int howManyBuyLottoTicket(int inputMoney) {
        return inputMoney / LOTTO_VALUE;
    }
}
