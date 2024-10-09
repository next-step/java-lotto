package lotto;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static lotto.LottoTicket.LOTTO_NUMBERS_COUNT;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoMachine = LottoMachine.of(new RandomLottoNumberStrategy());
    }

    public void run() {
        int amount = inputView.getAmountFromUser();
        List<LottoTicket> lottoTickets = lottoMachine.generateTickets(amount);

        List<Integer> winningNumbersFromUser = inputView.getWinningNumbersFromUser();
        WinningNumber winningNumber = WinningNumber.from(winningNumbersFromUser);

        Map<LottoResult, Integer> lottoResultIntegerMap = calculateResult(lottoTickets, winningNumber);
        resultView.showResult(lottoResultIntegerMap);

    }

    public Map<LottoResult, Integer> calculateResult(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        Map<LottoResult, Integer> result = new TreeMap<>();

        for (int i = 0; i < LOTTO_NUMBERS_COUNT; i++) {
            LottoResult lottoResult = LottoResult.of(i);
            result.put(lottoResult, 0);
        }

        for (LottoTicket lottoTicket : lottoTickets) {
            LottoResult lottoResult = LottoResult.of(winningNumber.matchLottoNumbers(lottoTicket));
            result.put(lottoResult, result.get(lottoResult) + 1);
        }

        return result;
    }
}
