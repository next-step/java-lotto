package domain.lotto;

import domain.lotto.genrate.LottoGenerator;
import domain.lotto.genrate.RandomGenerator;

public class LottoCount {
    private final Integer customLottoCount;
    private final Integer autoLottoCount;


    public LottoCount(Integer customLottoCount, Integer autoLottoCount) {
        this.customLottoCount = customLottoCount;
        this.autoLottoCount = autoLottoCount;
    }

    public Integer customLottoCount() {
        return customLottoCount;
    }

    public Integer autoLottoCount() {
        return autoLottoCount;
    }

    public long getCount(LottoGenerator item) {
        if (item instanceof RandomGenerator) {
            return autoLottoCount;
        }
        return customLottoCount;
    }
}
