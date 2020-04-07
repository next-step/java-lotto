package lotto;

import lotto.application.LottoBuyResponse;
import lotto.application.LottoService;
import lotto.domain.machine.LottoMachine;
import lotto.domain.rank.LottoRanks;
import lotto.ui.InputView;
import lotto.ui.LottoController;
import lotto.ui.ResultView;
import lotto.application.WinningLottoRequest;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(lottoService());
        LottoBuyResponse lottoBuyResponse = lottoController.buy(InputView.getRequestDto());
        ResultView.print(lottoBuyResponse);

        WinningLottoRequest winningLottoDto = InputView.getWinningLottoDto();

        LottoRanks lottoRanks = lottoController.match(lottoBuyResponse.getLotteryTotal(), winningLottoDto);
        ResultView.print(lottoRanks);
    }

    private static LottoService lottoService() {
        return new LottoService(lottoMachine());
    }

    private static LottoMachine lottoMachine() {
        return new LottoMachine();
    }

}
