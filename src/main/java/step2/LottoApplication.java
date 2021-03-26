package step2;

import step2.dto.LottoCreationRequestDto;
import step2.view.InputView;

public final class LottoApplication {
    private final InputView inputView;

    private LottoApplication(){
        this.inputView = InputView.getInstance();
    }

    public static final LottoApplication newInstance() {
        return new LottoApplication();
    }

    public void start() {
        LottoCreationRequestDto lottoCreationRequestDto = inputView.getLottoCreationRequestDto();
    }

}
