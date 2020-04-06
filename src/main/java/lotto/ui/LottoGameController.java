package lotto.ui;

import lotto.application.LottoService;
import lotto.domain.matcher.LottoGameResults;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.machine.LottoTickets;

public class LottoGameController {
    private final LottoMachineDto lottoMachineDto;
    private final LottoService lottoService;

    public LottoGameController(LottoMachineDto lottoMachineDto, LottoService lottoService) {
        this.lottoMachineDto = lottoMachineDto;
        this.lottoService = lottoService;
    }

    public LottoGameResults lotto(WinningRequestDto winningRequestDto) {

        LottoTickets lottoTickets = lottoService.game(lottoMachineDto);

        int bonusNumber = winningRequestDto.getBonusNumber();
        LottoNumbers lottoNumbers = winningRequestDto.getLottoNumbers();

        return lottoService.results(RequestAssembler.assembleWinningRequest(lottoNumbers, bonusNumber));
    }

}
