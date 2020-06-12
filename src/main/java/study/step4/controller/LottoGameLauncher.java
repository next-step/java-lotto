package study.step4.controller;

import study.step4.domain.*;
import study.step4.dto.LottoInputDto;
import study.step4.dto.LottoOutputDto;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class LottoGameLauncher {
    public static void main(String[] args) {
        LottoInputDto lottoInputDto = InputView.inputLottoValues();
        LottoTickets lottoTickets = LottoShop.buyLottos(lottoInputDto);
        LottoOutputDto lottoOutputDto = new LottoOutputDto(lottoTickets, lottoTickets.countLottoTickets(),
                                                            lottoInputDto.getManualAmount());
        ResultView.printLottoTickets(lottoOutputDto);
        WinningLotto winningLotto = InputView.inputLastWinningNumbers();
        WinningRanks winningRanks = lottoTickets.confirmWinningResult(winningLotto);
        ResultView.printLottoResult(winningRanks);
    }
}