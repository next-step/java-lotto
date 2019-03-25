package lotto.domain;

import java.util.List;

public class HalfManualLottoGenerator implements LottoGenerator {
    private final LottoGenerator lottoGenerator;

    public HalfManualLottoGenerator(String lottos) {
        this.lottoGenerator = ((null == lottos) ? new AutoLottoGenerator() : new ManualLottoGenerator(lottos));
    }


    @Override
    public Lotto generate() {
        return this.lottoGenerator.generate();
    }

    public static LottoBundle generateLottoBundle(List<String> manualLottos, long numberOfAutoLottos) {
        LottoBundle manualLottoBundle = ManualLottoGenerator.generateLottoBundle(manualLottos);
        LottoBundle autoLottoBundle = AutoLottoGenerator.generateLottoBundle(numberOfAutoLottos);

        manualLottoBundle.join(autoLottoBundle);

        return manualLottoBundle;
    }
}
