package lotto.strategy;

import lotto.domain.*;
import lotto.util.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerators {
    private List<LottoGenerator> lottoGenerators;

    public LottoGenerators(List<String> stringFormatManualLottos, int autoLottoCount) {
        List<LottoGenerator> lottoGenerators = new ArrayList<>();
        generateManualLotto(stringFormatManualLottos, lottoGenerators);
        generateAutoLotto(autoLottoCount, lottoGenerators);
        this.lottoGenerators = lottoGenerators;
    }

    private void generateManualLotto(List<String> stringFormatManualLottos, List<LottoGenerator> lottoGenerators) {
        for (String stringFormatManualLotto : stringFormatManualLottos) {
            List<LottoNumber> manualLotto = StringParser.parseToInts(stringFormatManualLotto);
            InputValidator.validateNumberCount(manualLotto.size());
            lottoGenerators.add(new ManualLottoGenerator(manualLotto));
        }
    }

    private void generateAutoLotto(int autoLottoCount, List<LottoGenerator> lottoGenerators) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottoGenerators.add(new RandomLottoGenerator());
        }
    }

    public Lottos generateLottos() {
        List<Lotto> lottos = lottoGenerators.stream()
                .map(lottoGenerator -> new Lotto(new LottoNumbers(lottoGenerator)))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

}
