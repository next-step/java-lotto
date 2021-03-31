package step2;

import step2.domain.lotto.Lottos;
import step2.service.LottoService;
import step2.domain.lotto.Lotto;
import step2.domain.request.Money;
import step2.view.InputView;
import step2.view.ResultView;

public final class LottoApplication {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService lottoService;

    private LottoApplication() {
        this.inputView = InputView.getInstance();
        this.resultView = ResultView.getInstance();
        this.lottoService = LottoService.of();
    }

    public static final LottoApplication newInstance() {
        return new LottoApplication();
    }

    public final void start() {
        generateAndShowLottoList();
    }

    public final void generateAndShowLottoList() {
        Money userMoney = inputView.getMoneyByClient();
        Lottos userLottos = lottoService.getLottos(userMoney);
        resultView.printLottoList(userLottos);
/*
        Lotto winningLotto = inputView.getWinningLottoByClient();
        LottoWinningResultResponseDto lottoWinningResultResponseDto = lottoService.getWinningResult(lottoWinningCheckRequestDto);
        resultView.printLottoResult(lottoWinningResultResponseDto, lottoCreationRequestDto.getMoney());
*/
    }

}
