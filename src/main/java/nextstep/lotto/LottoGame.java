package nextstep.lotto;

import nextstep.lotto.dto.*;
import nextstep.lotto.utils.LottoNumberUtil;
import nextstep.lotto.view.InputView;
import nextstep.lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.lotto.dto.LottoResultBoard.LOTTO_VALUE;

public class LottoGame {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.playLottoGame();
    }

    private void playLottoGame() {
        int moneyAmount = inputView.inputTotalAmountForBuy();

        LottoTickets userLottoTickets = buyTicket(howManyBuyLottoTicket(moneyAmount));
        resultView.showLottoTicket(userLottoTickets);

        LottoWinnerNumbers winnerNumbers = castWinnerNumber(inputView.inputWinnerNumber(),inputView.inputBonusNumber());

        resultView.showLottoResultBoard(LottoResultBoard.create(userLottoTickets, winnerNumbers));
    }

    private LottoWinnerNumbers castWinnerNumber(List<String> winnerNumbers,int bonusNumber) {
        return LottoWinnerNumbers.create(
                LottoNumberUtil.transStringNumberToLottoNumber(winnerNumbers),
                LottoNumber.create(bonusNumber)
        );
    }

    private LottoTickets buyTicket(int buyTicketCount) {
        List<LottoTicket> tickets = Stream.generate((LottoNumberUtil::generator))
                .limit(buyTicketCount)
                .map(LottoTicket::create)
                .collect(Collectors.toList());

        return LottoTickets.create(tickets);
    }
    private int howManyBuyLottoTicket(int inputMoney) {
        return inputMoney / LOTTO_VALUE;
    }
}
