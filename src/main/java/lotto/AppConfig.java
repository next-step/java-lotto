package lotto;

import lotto.application.LottoService;
import lotto.domain.LottoMachine;
import lotto.infra.NextStepLottoMachine;
import lotto.ui.LottoController;

public class AppConfig {

    public LottoController lottoController(){
        return new LottoController(lottoService());
    }

    public LottoService lottoService(){
        return new LottoService(lottoMachine());
    }

    public LottoMachine lottoMachine(){
        return new NextStepLottoMachine();
    }
}
