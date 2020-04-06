package lotto.application;

import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.LottoTickets;
import lotto.domain.matcher.LottoGameResults;
import lotto.domain.matcher.LottoMatcher;
import lotto.domain.matcher.WinningTicket;
import lotto.infrastructure.AutoLottoNumberStrategy;
import lotto.ui.LottoMachineDto;
import lotto.ui.WinningRequestDto;

public class LottoService {
    private final LottoMachine lottoMachine;
    private final LottoMatcher lottoMatcher;

    public LottoService(LottoMachine lottoMachine, LottoMatcher lottoMatcher) {
        this.lottoMachine = lottoMachine;
        this.lottoMatcher = lottoMatcher;
    }


    public LottoTickets game(LottoMachineDto lottoMachineDto) {
        LottoMachine lottoMachine = new LottoMachine(lottoMachineDto);
        return lottoMachine.buy(new AutoLottoNumberStrategy());
    }

    public LottoGameResults results(WinningRequestDto winningRequestDto) {
        WinningTicket winningTicket = new WinningTicket(winningRequestDto);
        LottoGameResults lottoGameResults = lottoMatcher.match(winningTicket);
        return lottoGameResults;
    }

}
