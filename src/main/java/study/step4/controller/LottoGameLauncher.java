package study.step4.controller;

import study.step4.domain.*;
import study.step4.dto.LottoInputDto;
import study.step4.dto.LottoOutputDto;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class LottoGameLauncher {
    public static void main(String[] args) {
        LottoInputDto lottoInputDto = InputView.inputLottoValues();
        LottoOutputDto lottoOutputDto = LottoShop.buyLottos(lottoInputDto);
        ResultView.printLottoTickets(lottoOutputDto);
        WinningLotto winningLotto = InputView.inputLastWinningNumbers();
        ResultView.printLottoResult(lottoOutputDto, winningLotto);
    }
}