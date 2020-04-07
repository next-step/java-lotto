package lotto.application;

import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.machine.LottoMachine;
import lotto.domain.rank.LottoRanks;
import lotto.domain.money.LottoMoney;
import lotto.domain.machine.infra.AutoLottoNumberStrategy;
import lotto.domain.machine.infra.ManualLottoNumberStrategy;

import java.util.List;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public ManualLottery buyManual(LottoMoney lottoMoney, List<LottoNumbers> lottoNumbers) {
        LottoMoney remainsMoney = lottoMoney.remainsMoney(lottoNumbers.size());
        Lottery lottery = lottoMachine.buy(new ManualLottoNumberStrategy(lottoNumbers));
        return new ManualLottery(lottery, remainsMoney);
    }

    public Lottery buyAuto(LottoMoney lottoMoney) {
        int autoCount = lottoMoney.getAvailableBuyingCount();
        return lottoMachine.buy(new AutoLottoNumberStrategy(autoCount));
    }

    public LottoRanks match(Lottery lottery, WinningLottoRequest winningLottoDto) {
        return lottery.matchWinningLotto(winningLottoDto);
    }
}
