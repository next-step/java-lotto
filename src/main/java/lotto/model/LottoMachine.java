package lotto.model;

import lotto.model.generator.LottoGenerator;
import lotto.model.generator.ManualGenerator;
import lotto.model.generator.RandomLottoGenerator;
import lotto.model.generator.WinningGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine {

    private List lottos = new ArrayList();

    public List<Lotto> buy(Money money, List<String> inputOfManualLotto) {
        lottos.addAll(generateManualLotto(inputOfManualLotto));

        Money money2 =money.subtract(Lotto.PRICE.times(inputOfManualLotto.size()));
        lottos.addAll(generateRandomLotto(money2));
        return lottos;
    }

    List<Lotto> generateManualLotto(List<String> inputOfLotto) {
        List lottos = new ArrayList();
        for (String numbersOfLotto : inputOfLotto) {
            ManualGenerator manualGenerator = new ManualGenerator(numbersOfLotto);
            lottos.add(manualGenerator.generator());
        }
        return lottos;
    }

    List<Lotto> generateRandomLotto(Money money) {
        long numberOfBuyLotto = money.countAvailable(Lotto.PRICE);

        LottoGenerator lottoGenerator = new RandomLottoGenerator();

        return LongStream.range(0, numberOfBuyLotto)
                .mapToObj((value) -> lottoGenerator.generator())
                .collect(Collectors.toList());
    }

    public static WinningLotto generateWinningLotto(String inputOfNumbers, int inputOfBonusNumber) {
        WinningGenerator winningGenerator = WinningGenerator.generate(inputOfNumbers, inputOfBonusNumber);
        return WinningLotto.of(winningGenerator.generator(), winningGenerator.getBonus());
    }
}
