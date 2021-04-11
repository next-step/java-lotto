package step2.controller;

import step2.utils.LottoNumberGenerator;
import step2.domain.LottoTickets;
import step2.domain.PrizeMoney;
import step2.domain.ResultDto;
import step2.service.LottoService;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoController {
    private LottoTickets lottoTickets;
    private List<Integer> winningNumbers;
    private final LottoService lottoService;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final PrizeMoney prizeMoney;
    private final ResultDto resultDto;

    public LottoController(LottoService lottoService, LottoNumberGenerator lottoNumberGenerator, PrizeMoney prizeMoney, ResultDto resultDto){
        this.lottoService = lottoService;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.prizeMoney = prizeMoney;
        this.resultDto = resultDto;
    }

    public void buyLottoTicket(){
        InputView.inputPayments();
        int numberOfLottoTickets = InputView.getNumberOfLottoTickets();
        lottoTickets = new LottoTickets(numberOfLottoTickets, lottoNumberGenerator);
        ResultView.printMyLottoTickets(lottoTickets);
    }

    public void inputWinningNumbers(){
        InputView.inputWinningNumberS();
        winningNumbers = InputView.getWinningNumbers();
    }

    public void showResult(){
        lottoService.calculateNumberOfMatchToWinningNumbers(lottoTickets.getLottoTickets(), winningNumbers, prizeMoney, resultDto);
        ResultView.prizeResult(prizeMoney, resultDto);
    }

}
