package step2.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final LottoGenerator autoLottoGenerator = new LottoGeneratorByAuto();

    public List<Lotto> generateLottos(List<String> manualLottos, Money moneyAfterPurchaseManualLotto) {
        List<Lotto> lottos = generateManualLottos(manualLottos);
        lottos.addAll(generateAutoLottos(moneyAfterPurchaseManualLotto));
        return lottos;
    }

    List<Lotto> generateManualLottos(List<String> manualLottos) {
        return manualLottos.stream()
                .map(this::generateManualLotto)
                .collect(Collectors.toList());
    }

    private Lotto generateManualLotto(String userInput) {
        final LottoGenerator lottoGenerator = new LottoGeneratorByManual(userInput);
        return lottoGenerator.generateLotto();
    }

    List<Lotto> generateAutoLottos(Money money) {
        return IntStream.range(0, money.determineLottoPurchaseCount())
                .mapToObj(count -> generateAutoLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateAutoLotto() {
        return autoLottoGenerator.generateLotto();
    }

    public WinningLotto generateWinningLotto(String userInput, Integer bonusNumber) {
        final LottoGenerator lottoGenerator = new LottoGeneratorByManual(userInput);
        return new WinningLotto(lottoGenerator.generateLotto(), bonusNumber);
    }

}
