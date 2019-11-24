package step4.generator;

import step4.model.Lotto;
import step4.model.Lottos;
import step4.model.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultLottoGenerator implements LottoGenerator {
    private LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
    private final List<Lotto> lottos;

    public DefaultLottoGenerator(String inputManualLotto) {
        lottos = Arrays.stream(inputManualLotto.split("\r?\n"))
                .map(s -> Lotto.ofComma(s))
                .collect(Collectors.toList());
    }

    public DefaultLottoGenerator(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public Lottos generate(Money money) {
        Money autoMoney = money.leftMoney(lottos.size());
        lottos.addAll(autoLottoGenerator.generate(autoMoney).getLottos());
        return new Lottos(lottos);
    }
}
