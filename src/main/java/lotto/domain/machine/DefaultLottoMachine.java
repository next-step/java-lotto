package lotto.domain.machine;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultLottoMachine implements LottoMachine {
    private final LottoMachine autoLottoMachine = new AutoLottoMachine();
    private final List<String> manualLottoNumbers;

    public DefaultLottoMachine(List<String> manualLottoNumbers) {
        this.manualLottoNumbers = Collections.unmodifiableList(new ArrayList<>(manualLottoNumbers));
    }

    @Override
    public List<Lotto> buyLotto(Money money) {
        List<Lotto> manualLottos = createLottos();
        Money autoMoney = money.buyManual(manualLottos.size());
        List<Lotto> autoLottos = autoLottoMachine.buyLotto(autoMoney);
        manualLottos.addAll(autoLottos);
        return manualLottos;
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoNumbers.size(); i++) {
            lottos.add(Lotto.ofComma(manualLottoNumbers.get(i)));
        }
        return lottos;
    }
}
