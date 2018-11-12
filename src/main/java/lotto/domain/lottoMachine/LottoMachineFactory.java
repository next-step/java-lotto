package lotto.domain.lottoMachine;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

import java.util.HashMap;
import java.util.Map;

public class LottoMachineFactory {
    private Map<Lotto.LottoType, LottoMachine> lottoMachines = new HashMap<>();

    public LottoMachineFactory() {
        lottoMachines.put(Lotto.LottoType.AUTO, new AutoLottoMachine());
        lottoMachines.put(Lotto.LottoType.MANUAL, new MaunalLottoMachine());
    }

    public LottoMachine createLottoMachine(Lotto.LottoType lottoType) {
        LottoMachine lottoMachine = lottoMachines.get(lottoType);
        if (lottoMachine != null) {
            return lottoMachine;
        }
        throw new IllegalArgumentException("지원하지않는 타입의 로또머신입니다.");
    }
}
