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

        int money = INPUT_VIEW.askEnterMoney();
        Lotto lotto = new Lotto(money);

        int countOfCustomLotto = INPUT_VIEW.askEnterCountOfCustomLotto();
        List<List<Integer>> customNumbers = INPUT_VIEW.askEnterCustomNumbers(countOfCustomLotto);
        LottoTickets lottoTickets = lotto.buy(customNumbers);

        RESULT_VIEW.printLottoNumber(new LottoTicketsDto(lottoTickets));

        List<Integer> winningNumbers = INPUT_VIEW.askEnterWinningNumbers();
        int bonus = INPUT_VIEW.askEnterBonusNumber();

        LottoResult lottoResult = lotto.match(winningNumbers, bonus);
        RESULT_VIEW.printLottoResult(LottoResultDto.of(lottoResult));
    }
}
