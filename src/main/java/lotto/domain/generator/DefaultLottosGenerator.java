package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottosGenerator;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultLottosGenerator implements LottosGenerator {
    private LottosGenerator autoLottosGenerator = new AutoLottoGenerator();
    private final String inputManualLottos;

    public DefaultLottosGenerator(String inputManualLottos) {
        this.inputManualLottos = inputManualLottos;
    }

    private static List<Lotto> generateLottos(String inputLottos) {
        return Arrays.stream(inputLottos.split("\r?\n"))
                .map(s -> Lotto.ofComma(s))
                .collect(Collectors.toList());
    }

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> manualLottos = generateLottos(inputManualLottos);
        Money autoMoney = money.buyManual(manualLottos.size());
        List<Lotto> autoLottos = autoLottosGenerator.generate(autoMoney);
        manualLottos.addAll(autoLottos);
        return manualLottos;
    }
}
