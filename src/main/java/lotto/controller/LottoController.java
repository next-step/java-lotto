package lotto.controller;

import lotto.model.*;
import lotto.view.ViewInput;

import java.util.Arrays;

public class LottoController {
    public static void run() {

        int expense = ViewInput.getExpense();
        int numLottoTicket = ViewInput.getAvailableNumLottoTicket(expense);


        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        LottoGame lottoGame = new LottoGame(winningNumbers);
        UserLottoRequest userLottoRequest = new UserLottoRequest(expense, numLottoTicket, lottoGame);
        userLottoRequest.checkWin();

    }
}
