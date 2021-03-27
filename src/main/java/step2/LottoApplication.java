package step2;

import step2.controller.LottoController;
import step2.dto.LottoCreationRequestDto;
import step2.view.InputView;
import step2.view.ResultView;

public final class LottoApplication {
    private final InputView inputView;
    private final ResultView resultView;

    private LottoApplication() {
        this.inputView = InputView.getInstance();
        this.resultView = ResultView.getInstance();
    }

    public static final LottoApplication newInstance() {
        return new LottoApplication();
    }

    public final void start() {
        generateAndShowLotto();

    }

    private final void generateAndShowLotto() {
        LottoCreationRequestDto lottoCreationRequestDto = inputView.getLottoCreationRequestDto();
        LottoController lottoController = LottoController.newInstance(lottoCreationRequestDto);
        resultView.printLottoList(lottoController.generateLottoList());
    }

}
