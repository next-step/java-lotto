package step3.domain.model.Lotto;


import step3.domain.strategy.lotto.LottoPolicyStrategy;
import step3.domain.strategy.lotto.PolicyStrategy;
import step3.param.ManualLottoNumbersParam;
import step3.param.ManualLottoParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.from(new LottoPolicyStrategy()));
        }
    }
    public Lottos(List<Lotto> lottos) {
       this.lottos = lottos;
    }

    public static Lottos fromManualLottos(ManualLottoParam manualLotto) {
        List<Lotto> lottos = manualLotto.getManualLottos()
                .stream()
                .map(numbers -> Lotto.fromManualLotto(new LottoPolicyStrategy(), numbers.getLottoNumbers()))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public static Lottos from(int lottoCount) {
        if (lottoCount < 0) {
            throw new IllegalArgumentException("음수의 갯수는 잘못된 값입니다.");
        }
        return new Lottos(lottoCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void combineLottos(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
    }
}
