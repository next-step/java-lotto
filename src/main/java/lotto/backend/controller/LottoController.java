package lotto.backend.controller;

import lotto.backend.domain.Lotto;
import lotto.backend.domain.LottoResult;
import lotto.backend.domain.LottoTickets;
import lotto.backend.dto.LottoResultDto;
import lotto.backend.dto.LottoTicketsDto;
import lotto.frontend.InputView;
import lotto.frontend.ResultView;

import java.util.List;

public class LottoController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final ResultView RESULT_VIEW = new ResultView();

    public void start() {
        Lotto lotto = new Lotto();

        LottoTickets lottoTickets = lotto.buy(INPUT_VIEW.askEnterMoney());
        RESULT_VIEW.printLottoNumber(LottoTicketsDto.of(lottoTickets));

        List<Integer> winningNumbers = INPUT_VIEW.askEnterWinningNumbers();
        int bonus = INPUT_VIEW.askEnterBonusNumber();

        LottoResult lottoResult = lotto.match(winningNumbers, bonus);
        RESULT_VIEW.printLottoResult(LottoResultDto.of(lottoResult));
    }
}
