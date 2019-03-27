package lotto.generator;

import lotto.Lotto;
import lotto.Lottos;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.InputUtil.convertToInt;
import static lotto.util.InputUtil.split;

public class ManualLottoGenerator implements LottoGenerator {
    private Lottos lottos;

    public ManualLottoGenerator(List<String> manualLottos) {
        this.lottos = new Lottos(manualLottos.stream()
                .map(manualLotto -> convertToLottoNumber(convertToInt(split(manualLotto))))
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    @Override
    public Lottos generateLottos() {
        return lottos;
    }
}
