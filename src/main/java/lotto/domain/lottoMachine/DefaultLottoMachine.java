package lotto.domain.lottoMachine;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRequest;
import lotto.domain.LottoTicket;

public class DefaultLottoMachine implements LottoMachine {
    private LottoMachine autoMachine;
    private LottoMachine manualMachine;

    public DefaultLottoMachine(AutoLottoMachine autoMachine, ManualLottoMachine manualMachine) {
        super();
        this.autoMachine = autoMachine;
        this.manualMachine = manualMachine;
    }

    @Override
    public LottoTicket createLotto(LottoRequest lottoRequest) {
        return LottoTicket.of(
                manualMachine.createLotto(lottoRequest), 
                autoMachine.createLotto(lottoRequest));
    }
    
}
