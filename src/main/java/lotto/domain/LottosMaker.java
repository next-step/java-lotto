package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottosMaker implements LottosGenerator{

    private static final int ZERO = 0;
    private static final String DELIMITER = ", ";

    @Override
    public Lottos generate(Money money) {
        CreatableLotto lotto = new LottoFactory().createAutoLotto();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO; i < money.purchaseCount(); i++) {
            lottos.add(new Lotto(lotto.makeLotto()));
        }
        return new Lottos(lottos);
    }

    @Override
    public Lottos generate(List<String> manualLottos) {
        return new Lottos(manualLottos
                .stream()
                .map(lotto -> new Lotto(createManualLotto(lotto)))
                .collect(Collectors.toList()));
    }

    private List<LottoNo> createManualLotto(String lotto) {
        return new LottoFactory()
                .createManualLotto(lotto.split(DELIMITER))
                .makeLotto();
    }
}
