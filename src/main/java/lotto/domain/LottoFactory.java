package lotto.domain;

import lotto.strategy.ManualLottoGenerator;
import lotto.strategy.RandomLottoGenerator;
import lotto.util.StringParser;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lottos generateLottos(List<String> stringFormatManualLottos, int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        generateManualLotto(stringFormatManualLottos, lottos);
        generateAutoLotto(autoLottoCount, lottos);
        return new Lottos(lottos);
    }

    private static void generateManualLotto(List<String> stringFormatManualLottos, List<Lotto> lottos) {
        for (String stringFormatManualLotto : stringFormatManualLottos) {
            List<LottoNumber> manualLotto = StringParser.parseToInts(stringFormatManualLotto);
            InputValidator.validateNumberCount(manualLotto.size());
            lottos.add(new Lotto(new LottoNumbers(new ManualLottoGenerator(manualLotto))));
        }
    }

    private static void generateAutoLotto(int autoLottoCount, List<Lotto> lottos) {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new Lotto(new LottoNumbers(randomLottoGenerator)));
        }
    }

}
