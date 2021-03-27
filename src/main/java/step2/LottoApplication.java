package step2;

import step2.controller.LottoController;
import step2.dto.LottoCreationRequestDto;
import step2.view.InputView;
import step2.view.ResultView;

public final class LottoApplication {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoController lottoController;

    private LottoApplication() {
        this.inputView = InputView.getInstance();
        this.resultView = ResultView.getInstance();
        this.lottoController = LottoController.newInstance();
    }

    public static final LottoApplication newInstance() {
        return new LottoApplication();
    }

    public final void start() {
        generateAndShowLottoList();
    }

    public final void generateAndShowLottoList() {
        LottoCreationRequestDto lottoCreationRequestDto = inputView.getLottoCreationRequestDto();
        resultView.printLottoList(lottoController.generateLottoList(lottoCreationRequestDto));
    }

}
