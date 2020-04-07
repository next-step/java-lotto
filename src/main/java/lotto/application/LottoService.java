package lotto.application;

import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.LottoMoney;
import lotto.infrastructure.AutoLottoNumberStrategy;

import java.util.List;

public class LottoService {

    public ManualLottery buyManual(LottoMoney lottoMoney, List<LottoNumbers> lottoNumbers) {
        LottoMoney remainsMoney = lottoMoney.remainsMoney(lottoNumbers.size());
        Lottery lottery = Lottery.of(lottoNumbers);
        return new ManualLottery(lottery, remainsMoney);
    }

    public Lottery buyAuto(LottoMoney lottoMoney) {
        int autoCount = lottoMoney.getAvailableBuyingCount();
        LottoMachine lottoMachine = new LottoMachine(autoCount);
        return lottoMachine.buyAuto(new AutoLottoNumberStrategy());
    }
}
