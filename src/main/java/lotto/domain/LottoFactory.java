package lotto.domain;

import lotto.StringParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    private static List<Lotto> createAutoLottos(Money money, List<String> manualLottoNumbers, NumberGeneratorStrategy strategy) {

        int lottoCount = money.getTotalPurchaseSize() - manualLottoNumbers.size();

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(strategy.generateNumbers()));
        }
        return lottos;
    }

    private static List<Lotto> createManualLottos(List<String> manualLottoNumbers) {

        List<Lotto> lottos = new ArrayList<>();

        for (String numbers : manualLottoNumbers) {
            lottos.add(Lotto.of(StringParser.getParseNumbers(numbers)));
        }
        return lottos;
    }

    public static List<Lotto> createLottos(Money money, List<String> manualLottoNumbers){
        validationCheck(money, manualLottoNumbers);
        List<Lotto> autoLottos = createAutoLottos(money, manualLottoNumbers, new RandomNumberGeneratorStrategy());
        autoLottos.addAll(createManualLottos(manualLottoNumbers));
        return Collections.unmodifiableList(autoLottos);
    }

    private static void validationCheck(Money money, List<String> manualLottoNumbers) {
        if (manualLottoNumbers == null || manualLottoNumbers.size() > money.getTotalPurchaseSize()) {
            throw new IllegalArgumentException("수동으로 구매할 로또 개수가 예산을 초과합니다.");
        }
    }
}
