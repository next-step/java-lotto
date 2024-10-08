package lotto;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoMachine =  LottoMachine.of(new RandomLottoNumberStrategy());
    }

    public void run() {
        int amount = inputView.getAmountFromUser();
        List<LottoTicket> lottoTickets = lottoMachine.generateTickets(amount);
        List<Integer> winningNumbersFromUser = inputView.getWinningNumbersFromUser();
        WinningNumber winningNumber = WinningNumber.from(winningNumbersFromUser);
        Map<LottoResult, Integer> lottoResultIntegerMap = calculateResult(lottoTickets, winningNumber);
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println("lottoTicket = " + lottoTicket);
        }
        System.out.println("lottoResultIntegerMap = " + lottoResultIntegerMap);

    }
    public Map<LottoResult, Integer> calculateResult(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        Map<LottoResult, Integer> result = new HashMap<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            int numberOfMatchedLottoNumber = winningNumber.matchLottoNumbers(lottoTicket);
            LottoResult lottoResult = LottoResult.of(numberOfMatchedLottoNumber);
            result.put(lottoResult, result.getOrDefault(lottoResult, 0) + 1);
        }

        return result;
    }
}
