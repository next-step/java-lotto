package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class DefaultLottoMachine implements LottoMachine {
    @Override
    public LottoGroup buyLotto(Money money, List<String> manualLottoNumbers) {
        List<Lotto> lottos = createManualLottos(manualLottoNumbers);
        Money autoMoney = money.buyManual(lottos.size());
        lottos.addAll(createAutoLottos(autoMoney));
        return new LottoGroup(lottos);
    }

    private List<Lotto> createAutoLottos(Money autoMoney) {
        List<Lotto> lottos = new ArrayList<>();
        int countOfLotto = autoMoney.getCountOfLotto();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(AutoLottoGenerator.createLotto());
        }
        return lottos;
    }

    private List<Lotto> createManualLottos(List<String> manualLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoNumbers.size(); i++) {
            lottos.add(Lotto.ofComma(manualLottoNumbers.get(i)));
        }
        return lottos;
    }
}
