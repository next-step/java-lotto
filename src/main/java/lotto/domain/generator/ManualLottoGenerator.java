package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.InputUtil.convertToInt;
import static lotto.util.InputUtil.split2;

public class ManualLottoGenerator implements LottoGenerator {
    private Lottos lottos;

    public ManualLottoGenerator(List<String> manualLottos) {
        this.lottos = new Lottos(manualLottos.stream()
                .map(manualLotto -> new Lotto(LottoGenerator.convertToLottoNumber(convertToInt(split2(manualLotto)))))
                .collect(Collectors.toList()));
    }

    @Override
    public Lottos generateLottos() {
        return lottos;
    }
}
